package com.foo;

import com.antwerkz.bottlerocket.BottleRocket;
import com.antwerkz.bottlerocket.BottleRocketTest;
import com.foo.entity.MyCustomMongoDataEntity;
import com.foo.entity.MyFancyInterfaceEntity;
import com.foo.entity.WithEntity;
import com.github.zafarkhaja.semver.Version;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.annotations.experimental.EmbeddedBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReproducerTest extends BottleRocketTest {
    private Datastore datastore;

    public ReproducerTest() {
        MongoClient mongo = getMongoClient();
        MongoDatabase database = getDatabase();
        database.drop();
        datastore = Morphia.createDatastore(mongo, getDatabase().getName());
    }

    @NotNull
    @Override
    public String databaseName() {
        return "morphia_repro";
    }

    @Nullable
    @Override
    public Version version() {
        return BottleRocket.DEFAULT_VERSION;
    }

    @Test
    public void reproduce() {
        reproduceWithAnnotation();

        datastore.getMapper().mapExternal(EmbeddedBuilder.builder().useDiscriminator(false), MyFancyInterface.class);
        datastore.getMapper().mapExternal(EmbeddedBuilder.builder().useDiscriminator(false), MyCustomMongoData.class);

        Map<String, MyFancyInterface> map = new HashMap<>();
        map.put("example", new MyCustomMongoData("val"));

        WithoutEntity entity = new WithoutEntity(UUID.randomUUID(), map);

        datastore.save(entity);

        WithoutEntity myEntity = datastore.find(WithoutEntity.class).first();
        System.out.println(myEntity.toString());
    }

    public void reproduceWithAnnotation() {
        Map<String, MyFancyInterfaceEntity> map = new HashMap<>();
        map.put("example", new MyCustomMongoDataEntity("val"));

        WithEntity entity = new WithEntity(UUID.randomUUID(), map);

        datastore.save(entity);

        WithEntity myEntity = datastore.find(WithEntity.class).first();
        System.out.println(myEntity.toString());
    }

}

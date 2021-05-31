package com.foo.entity;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.Map;
import java.util.UUID;

@Entity
public class WithEntity {

    @Id
    private UUID id;
    private Map<String, MyFancyInterfaceEntity> options;

    public WithEntity(UUID id, Map<String, MyFancyInterfaceEntity> options) {
        this.id = id;
        this.options = options;
    }

    public WithEntity() {
    }

    @Override
    public String toString() {
        return "WithEntity{" +
                "id=" + id +
                ", options=" + options +
                '}';
    }
}

package com.foo;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.Map;
import java.util.UUID;

@Entity
public class WithoutEntity {

    @Id
    private UUID id;
    private Map<String, MyFancyInterface> options;

    public WithoutEntity(UUID id, Map<String, MyFancyInterface> options) {
        this.id = id;
        this.options = options;
    }

    public WithoutEntity() {
    }

    @Override
    public String toString() {
        return "WithoutEntity{" +
                "id=" + id +
                ", options=" + options +
                '}';
    }
}

package com.foo.entity;


public class MyCustomMongoDataEntity implements MyFancyInterfaceEntity {
    private String val;

    public MyCustomMongoDataEntity(String val) {
        this.val = val;
    }

    public MyCustomMongoDataEntity() {
    }

    @Override
    public String toString() {
        return "MyCustomMongoDataEntity{" +
                "val='" + val + '\'' +
                '}';
    }
}

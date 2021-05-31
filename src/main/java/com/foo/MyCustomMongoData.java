package com.foo;

public class MyCustomMongoData implements MyFancyInterface {
    private String val;

    public MyCustomMongoData(String val) {
        this.val = val;
    }

    public MyCustomMongoData() {
    }

    @Override
    public String toString() {
        return "MyCustomMongoData{" +
                "val='" + val + '\'' +
                '}';
    }
}

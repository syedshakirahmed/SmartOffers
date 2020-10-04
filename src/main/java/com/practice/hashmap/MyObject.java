package com.practice.hashmap;

public class MyObject {
    public MyObject(String id) {
        this.id = id;
    }

    private String id;
    public boolean equals(Object obj) {
        MyObject myObject = (MyObject) obj;
        return myObject.id.equals(id)?true:false;
    }
    public int hashCode() {
        return Integer.valueOf(id);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

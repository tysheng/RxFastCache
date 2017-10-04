package me.tysheng.rxfastcachedemo;

import java.util.List;

/**
 * Created by tysheng
 * Date: 2016/9/24 09:04.
 * Email: tyshengsx@gmail.com
 */

class Person {
    private String name;
    private int age;
    private List<String> languages;

    Person(String name, int age, List<String> languages) {
        this.name = name;
        this.age = age;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", languages=" + languages +
                '}';
    }
}

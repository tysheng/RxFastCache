package me.tysheng.rxfastcachedemo;

import java.util.List;

/**
 * Created by tysheng
 * Date: 2016/9/24 09:04.
 * Email: tyshengsx@gmail.com
 */

public class Person {
    public String name;
    public int age;
    public List<String> languages;

    public Person() {
    }

    public Person(String name, int age, List<String> languages) {
        this.name = name;
        this.age = age;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "age: " + age +
                "languages" + languages.size();
    }
}

package com.itmayiedu.api.entity;

import lombok.Data;

@Data
public class UserEntity {
    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private Integer age;
}

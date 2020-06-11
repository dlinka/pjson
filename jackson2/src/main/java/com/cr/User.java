package com.cr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {

    //设置序列化的json字段名
    //设置反序列化的json字段名对应的属性
    @JsonProperty("name")
    private String username;
    private int age;
    //序列化的时候忽略这个字段
    //反序列化的时候忽略这个字段
    @JsonIgnore
    private LocalDate birthday;
    private Map<String, User> parents;
    private List<User> friends;
    //如果字段为null,序列化的时候忽略
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User leader;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public static User createUser(){
        User user = new User();
        user.setUsername("cr");
        user.setAge(27);
        user.setBirthday(LocalDate.now());
        Map<String, User> parents = new HashMap<>();
        parents.put("mom", new User("dj", 60));
        user.setParents(parents);
        List<User> friends = new ArrayList<>();
        friends.add(new User("cz", 27));
        user.setFriends(friends);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", parents=" + parents +
                ", friends=" + friends +
                ", leader=" + leader +
                '}';
    }

}

package com.cr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    @JsonProperty("name")
    private String username;
    private int age;
    @JsonIgnore
    private LocalDate birthday;
    private Map<String, User> parents;
    private List<User> friends;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User leader;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Map<String, User> getParents() {
        return parents;
    }

    public void setParents(Map<String, User> parents) {
        this.parents = parents;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", parents=" + parents +
                ", friends=" + friends +
                ", leader=" + leader +
                '}';
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
}

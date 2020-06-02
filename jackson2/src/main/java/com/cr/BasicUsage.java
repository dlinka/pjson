package com.cr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class BasicUsage {

    static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    public static void main(String[] args) throws IOException {
        //Object转JSON
        User user = User.createUser();
        String json1 = mapper.writeValueAsString(user);
        System.out.println(json1);
        String json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(json2);

        //JSON转Object
        User user1 = mapper.readValue(json1, User.class);
        System.out.println(user1);
        User user2 = mapper.readValue(json2, User.class);
        System.out.println(user2);

        //List和JSON互转
        List<User> userList = new ArrayList<>();
        userList.add(User.createUser());
        userList.add(User.createUser());
        String json3 = mapper.writeValueAsString(userList);
        System.out.println(json3);
        userList = mapper.readValue(json3, new TypeReference<List<User>>() {});
        System.out.println(userList);
        userList = Arrays.asList(mapper.readValue(json3, User[].class));
        System.out.println(userList);

        //Map和JSON互转
        Map<String, User> userMap = new HashMap<>();
        userMap.put("cr", new User("cr", 27));
        userMap.put("zj", new User("zj", 18));
        String json4 = mapper.writeValueAsString(userMap);
        System.out.println(json4);
        userMap = mapper.readValue(json4, new TypeReference<Map<String, User>>() {});
        System.out.println(userMap);
    }

}

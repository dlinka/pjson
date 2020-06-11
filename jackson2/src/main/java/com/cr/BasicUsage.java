package com.cr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class BasicUsage {

    static ObjectMapper mapper = new ObjectMapper();

    static {
        //忽略没有匹配的JSON字段
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //序列化忽略null的字段
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static void main(String[] args) throws IOException {
        //Object和JSON互转
        User user = User.createUser();
        String json1 = mapper.writeValueAsString(user);
        String json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(json1);
        System.out.println(json2);
        User user1 = mapper.readValue(json1, User.class);
        System.out.println(user1);

        System.out.println("---");

        //List和JSON互转
        List<User> userList = new ArrayList<>();
        userList.add(User.createUser());
        userList.add(User.createUser());
        String json3 = mapper.writeValueAsString(userList);
        System.out.println(json3);
        userList = mapper.readValue(json3, new TypeReference<List<User>>() {});
        System.out.println(userList);

        System.out.println("---");

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

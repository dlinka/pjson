package com.cr;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TreeUsage {

    static ObjectMapper mapper = new ObjectMapper();
    static User user = User.createUser();

    public static void main(String[] args) throws IOException {
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        read(json);
    }

    private static void read(String json) throws IOException {
        JsonNode jsonNode = mapper.readTree(json);
        String name = jsonNode.path("name").asText();
        System.out.println(name);
        int age = jsonNode.path("age").asInt();
        System.out.println(age);

        JsonNode parents = jsonNode.path("parents");
        if (!parents.isMissingNode()) {
            JsonNode mom = parents.path("mom");
            String momName = mom.path("name").asText();
            System.out.println(momName);
        }

        JsonNode friends = jsonNode.path("friends");
        if (friends.isArray()) {
            for (JsonNode friend : friends) {
                String friendName = friend.path("name").asText();
                System.out.println(friendName);
                int friendAge = friend.path("age").asInt();
                System.out.println(friendAge);
            }
        }
    }

}

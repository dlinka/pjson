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
        System.out.println(jsonNode.path("name").asText());
        System.out.println(jsonNode.path("age").asInt());

        JsonNode parents = jsonNode.path("parents");
        if (!parents.isMissingNode()) {
            JsonNode mom = parents.path("mom");
            System.out.println(mom.path("name").asText());
        }

        JsonNode friends = jsonNode.path("friends");
        if (friends.isArray()) {
            for (JsonNode friend : friends) {
                System.out.println(friend.path("name").asText());
                System.out.println(friend.path("age").asInt());
            }
        }
    }

}

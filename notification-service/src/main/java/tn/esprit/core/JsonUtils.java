package tn.esprit.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Notification fromJson(String json) throws IOException {
        return mapper.readValue(json, Notification.class);
    }
}

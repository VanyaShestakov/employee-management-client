package com.ivanshestakov.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

public class JsonUtils {

    @SneakyThrows
    public static String toJson(Object object)  {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    @SneakyThrows
    public static <T> T toObject(String jsonString, Class<T> returned) {
        return new ObjectMapper().readValue(jsonString, returned);
    }
}

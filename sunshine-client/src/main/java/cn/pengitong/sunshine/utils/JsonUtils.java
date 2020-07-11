package cn.pengitong.sunshine.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule())
            .registerModule(new JodaModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);


    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String marshal(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T unmarshal(String jsonString, Class<T> type) throws IOException {
        return objectMapper.readValue(jsonString, type);
    }

    public static <T> T unmarshal(String jsonString, TypeReference<T> type) throws IOException {
        return objectMapper.readValue(jsonString, type);
    }

    public static <T> T transformTo(Object object, Class<T> type) throws IOException {
        if (object == null) {
            throw new IllegalArgumentException("source object can not be null.");
        }
        return unmarshal(marshal(object), type);
    }

    public static <T> T treeToObject(JsonNode node, TypeReference<T> type) throws IOException {
        return objectMapper.readerFor(type).readValue(node);
    }

    public static <T> T treeToObject(JsonNode node, Class<T> type) throws IOException {
        return objectMapper.treeToValue(node, type);
    }

    public static String silentMarshal(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T jsonToObjectSilent(String json, Class<T> type) {
        try {
            JsonNode node =  objectMapper.readTree(json);
            return objectMapper.readerFor(type).readValue(node);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}

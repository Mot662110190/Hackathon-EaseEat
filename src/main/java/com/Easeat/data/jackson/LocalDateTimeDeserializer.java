package com.Easeat.data.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
private static DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public LocalDateTimeDeserializer() {
        this(null);
    }

    public LocalDateTimeDeserializer(Class<LocalDateTime> clazz) {
        super(clazz);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(jsonParser.getText(), FORMATTER);
    }
}

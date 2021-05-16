package com.marco.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marco.json.serializer.model.Response;

import java.io.IOException;

public class CustomResponseSerializer extends StdSerializer<Response> {


    public CustomResponseSerializer() {
        this(null);
    }

    protected CustomResponseSerializer(Class<Response> t) {
        super(t);
    }

    @Override
    public void serialize(Response response, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField(String.valueOf(response.getResponseCode()), response.getBody());
        jsonGenerator.writeEndObject();
    }
}

package com.marco;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.marco.json.model.Error;
import com.marco.json.model.Result;
import com.marco.json.other.OtherBean;
import com.marco.json.serializer.CustomResponseSerializer;
import com.marco.json.serializer.model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private final String result_500 = """
            {
                        
              "responses": {
                        
                "500": {
                        
                  "description": "Internal Server Error",
                        
                  "content": {}
                        
                }
                        
            }
            """;

    private final String result_400 = """
            {
                        
              "responses": {
                        
                "400": {
                        
                  "description": "Internal Server Error",
                        
                  "content": {}
                        
                }
                        
            }
            """;

    private final String result_200 = """
            {
                        
              "responses": {
                        
                "200": {
                        
                  "description": "Internal Server Error",
                        
                  "content": {}
                        
                }
                        
            }
            """;
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        var mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomResponseSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Response.class, new CustomResponseSerializer());
        mapper.registerModule(module);

        var errorResponse = new Response<>(500, new Error("Internal Server Error",
                new OtherBean(UUID.randomUUID().toString(), LocalDate.now())));

        String responseJson = mapper.writeValueAsString(errorResponse);
        System.out.println(responseJson);
        Assert.assertTrue(responseJson.contains("\"500\""));
        Assert.assertTrue(responseJson.contains("\"description\":\"Internal Server Error\""));

        var okResponse = new Response<>(200, new Result("Created",
                new OtherBean(UUID.randomUUID().toString(), LocalDate.now())));
        responseJson = mapper.writeValueAsString(okResponse);
        System.out.println(responseJson);
        Assert.assertTrue(responseJson.contains("\"200\""));
        Assert.assertTrue(responseJson.contains("\"description\":\"Created\""));
    }
}

package com.marco;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

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
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomResponseSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Response.class, new CustomResponseSerializer());
        mapper.registerModule(module);

        var inner = new Inner<InnerType>();
        inner.setDescription("this is a description");
        inner.setContent(new InnerType("field 1", 2000));

        var response = new Response();
        response.setResponseCode(ResponseCode.INTERNAL_ERROR);
        response.setInner(inner);

        String responseJson = mapper.writeValueAsString(response);
        System.out.println(responseJson);

        response.setResponseCode(ResponseCode.BAD_REQUEST);
        responseJson = mapper.writeValueAsString(response);
        System.out.println(responseJson);


        response.setResponseCode(ResponseCode.OK);
        responseJson = mapper.writeValueAsString(response);
        System.out.println(responseJson);
    }
}

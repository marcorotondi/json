package com.marco.json.serializer.model;


import java.io.Serializable;

//@JsonSerialize(as = CustomResponseSerializer.class)
public class Response<T> implements Serializable {

    private final int responseCode;

    private final Body<T> body;

    public Response(int responseCode, Body<T> body) {
        this.responseCode = responseCode;
        this.body = body;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Body<T> getBody() {
        return body;
    }
}


package com.marco.json.serializer.model.response;

public class Response<T> {

    private Inner<T> inner;

    private ResponseCode responseCode;

    public Response() {
    }

    public Inner<T> getInner() {
        return inner;
    }

    public void setInner(Inner<T> inner) {
        this.inner = inner;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}


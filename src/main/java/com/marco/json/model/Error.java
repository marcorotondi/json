package com.marco.json.model;

import com.marco.json.other.OtherBean;
import com.marco.json.serializer.model.Body;

public class Error implements Body<OtherBean> {

    private final String description;

    private final OtherBean error;

    public Error(String description, OtherBean error) {
        this.description = description;
        this.error = error;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public OtherBean getContent() {
        return error;
    }
}

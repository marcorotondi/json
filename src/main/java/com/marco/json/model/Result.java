package com.marco.json.model;

import com.marco.json.other.OtherBean;
import com.marco.json.serializer.model.Body;

public class Result implements Body<OtherBean> {

    private final String description;

    private final OtherBean result;

    public Result(String description, OtherBean result) {
        this.description = description;
        this.result = result;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public OtherBean getContent() {
        return result;
    }
}

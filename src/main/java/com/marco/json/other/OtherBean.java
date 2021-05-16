package com.marco.json.other;

import java.time.LocalDate;

public class OtherBean {

    private final String id;

    private final LocalDate current;

    public OtherBean(String id, LocalDate current) {
        this.id = id;
        this.current = current;
    }

    public String getId() {
        return id;
    }

    public LocalDate getCurrent() {
        return current;
    }
}

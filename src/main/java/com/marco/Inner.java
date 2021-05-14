package com.marco;

public class Inner<T> {

    private String description;

    private T content;

    public Inner() {
    }

    public Inner(String description, T content) {
        this.description = description;
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

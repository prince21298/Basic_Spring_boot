package com.crud_operation.crud_operation.api.response;

import com.crud_operation.crud_operation.api.model.Users;

import java.util.List;
import java.util.Optional;

public class ErrorModifier extends Exception {
    private boolean success;
    private Optional<List<Users>> data;
    private String message;

    public ErrorModifier(String string) {
        this.success = false;
        this.message = string;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Optional<List<Users>> getData() {
        return data;
    }

    public void setData(Optional<List<Users>> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.crud_operation.crud_operation.api.response;

import com.crud_operation.crud_operation.api.model.Users;

import java.util.List;
import java.util.Optional;

public class ResponseModifier {
    private boolean success;
    private Optional<List<Users>> data;
    private String message;

    public ResponseModifier() {
        this.success = true;
        this.message = "Request successful";
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

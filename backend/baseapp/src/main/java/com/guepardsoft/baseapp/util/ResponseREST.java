package com.guepardsoft.baseapp.util;

public class ResponseREST {
    private boolean success;
    private String message;
    private String v;
    private Object results;

    public ResponseREST() {
        success = false;
        v = "1";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResponseREST{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", v='" + v + '\'' +
                ", results=" + results +
                '}';
    }
}
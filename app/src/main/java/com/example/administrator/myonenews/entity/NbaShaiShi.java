package com.example.administrator.myonenews.entity;

/**
 * Created by Administrator on 2016/12/30.
 */

public class NbaShaiShi{
    private String error_code;
    private String reason;
    private NbaResult result;

    public NbaResult getResult() {
        return result;
    }

    public void setResult(NbaResult result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "NbaShaiShi{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}

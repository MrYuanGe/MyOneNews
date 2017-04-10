package com.example.administrator.myonenews.entity;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CaijinNews {
    private String error_code;
    private String reaseon;
    private CaiJingResult result;

    @Override
    public String toString() {
        return "CaijinNews{" +
                "error_code='" + error_code + '\'' +
                ", reaseon='" + reaseon + '\'' +
                ", result=" + result +
                '}';
    }

    public CaiJingResult getResult() {
        return result;
    }

    public void setResult(CaiJingResult result) {
        this.result = result;
    }

    public String getReaseon() {

        return reaseon;
    }

    public void setReaseon(String reaseon) {
        this.reaseon = reaseon;
    }

    public String getError_code() {

        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}

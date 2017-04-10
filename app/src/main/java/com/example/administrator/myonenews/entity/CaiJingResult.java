package com.example.administrator.myonenews.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CaiJingResult {
    private List<CaiJingMessage> data;
    private String stat;

    public List<CaiJingMessage> getData() {
        return data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void setData(List<CaiJingMessage> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CaiJingResult{" +
                "data=" + data +
                ", stat='" + stat + '\'' +
                '}';
    }
}

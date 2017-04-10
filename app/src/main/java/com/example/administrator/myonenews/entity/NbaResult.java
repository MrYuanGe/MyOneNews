package com.example.administrator.myonenews.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class NbaResult {
    private List<DataMessage> data;
    private String stat;

    public List<DataMessage> getData() {
        return data;
    }

    public void setData(List<DataMessage> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NbaResult{" +
                "data=" + data +
                ", stat='" + stat + '\'' +
                '}';
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}

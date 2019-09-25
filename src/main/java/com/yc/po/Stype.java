package com.yc.po;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Stype implements Serializable {
    private static final long serialVersionUID = 5763880076159908003L;
    private Integer stid;

    private String stname;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    @Override
    public String toString() {
        return "Stype{" +
                "stid=" + stid +
                ", stname='" + stname + '\'' +
                '}';
    }
}
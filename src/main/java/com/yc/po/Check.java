package com.yc.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Check implements Serializable {
    private static final long serialVersionUID = -654528440309056262L;
    private String uname;

    private Date lefttime;

    private String uidcard;

    private Integer hid;

    private Date intime;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getLefttime() {
        return lefttime;
    }

    public void setLefttime(Date lefttime) {
        this.lefttime = lefttime;
    }

    public String getUidcard() {
        return uidcard;
    }

    public void setUidcard(String uidcard) {
        this.uidcard = uidcard;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    @Override
    public String toString() {
        return "Check{" +
                "uname='" + uname + '\'' +
                ", lefttime='" + lefttime + '\'' +
                ", uidcard='" + uidcard + '\'' +
                ", hid=" + hid +
                ", intime=" + intime +
                '}';
    }
}
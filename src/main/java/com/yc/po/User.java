package com.yc.po;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7358744196146037041L;
    private Integer uid;

    private String uname;

    private String usex;

    private String utel;

    private String upwd;

    private String umon;

    private String uidcard;

    private String upic;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUmon() {
        return umon;
    }

    public void setUmon(String umon) {
        this.umon = umon;
    }

    public String getUidcard() {
        return uidcard;
    }

    public void setUidcard(String uidcard) {
        this.uidcard = uidcard;
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                ", utel='" + utel + '\'' +
                ", upwd='" + upwd + '\'' +
                ", umon='" + umon + '\'' +
                ", uidcard='" + uidcard + '\'' +
                ", upic='" + upic + '\'' +
                '}';
    }
}
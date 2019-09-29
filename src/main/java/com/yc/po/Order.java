package com.yc.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -8021846148060248545L;
    private Integer oid;

    private String ocid;

    private Integer uid;

    private Integer ostatus;

    private Double oprice;

    private Date otime;

    private String osum;

    private String opay;

    private Integer sid;

    private Integer rid;
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOcid() {
        return ocid;
    }

    public void setOcid(String ocid) {
        this.ocid = ocid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public String getOsum() {
        return osum;
    }

    public void setOsum(String osum) {
        this.osum = osum;
    }

    public String getOpay() {
        return opay;
    }

    public void setOpay(String opay) {
        this.opay = opay;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", ocid='" + ocid + '\'' +
                ", uid=" + uid +
                ", ostatus=" + ostatus +
                ", oprice=" + oprice +
                ", otime=" + otime +
                ", osum='" + osum + '\'' +
                ", opay='" + opay + '\'' +
                ", sid=" + sid +
                ", rid=" + rid +
                ", hotel=" + hotel +
                '}';
    }
}
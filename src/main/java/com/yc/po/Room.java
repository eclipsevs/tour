package com.yc.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Administrator
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 8761432764256292236L;
    private Integer rid;

    private Integer id;

    private double rprice;

    private Integer rstatus;

    private String rtype;

    private String rdesc;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public Integer getRstatus() {
        return rstatus;
    }

    public void setRstatus(Integer rstatus) {
        this.rstatus = rstatus;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", id=" + id +
                ", rprice=" + rprice +
                ", rstatus=" + rstatus +
                ", rtype='" + rtype + '\'' +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}
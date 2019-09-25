package com.yc.po;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Orderitems implements Serializable {
    private static final long serialVersionUID = 8024834615389359454L;
    private Integer otid;

    private Integer oid;

    private String otcid;

    public Integer getOtid() {
        return otid;
    }

    public void setOtid(Integer otid) {
        this.otid = otid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOtcid() {
        return otcid;
    }

    public void setOtcid(String otcid) {
        this.otcid = otcid;
    }

    @Override
    public String toString() {
        return "Orderitems{" +
                "otid=" + otid +
                ", oid=" + oid +
                ", otcid=" + otcid +
                '}';
    }
}
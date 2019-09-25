package com.yc.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = 4017394861934976851L;
    private Integer cid;

    private Integer oid;

    private Integer uid;

    private Integer gid;

    private Integer sid;

    private Integer gtid;

    private String cpics;

    private Date ctime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getCpics() {
        return cpics;
    }

    public void setCpics(String cpics) {
        this.cpics = cpics;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "cid=" + cid +
                ", oid=" + oid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", sid=" + sid +
                ", gtid=" + gtid +
                ", cpics='" + cpics + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
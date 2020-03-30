package com.yc.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = 4017394861934976851L;

    /**
     * 评论ID号
     */
    private Integer cid;

    /**
     * 该条评论对应的用户ID号
     */
    private Integer uid;

    /**
     * 该条评论对应的景点ID号
     */
    private Integer sid;

    /**
     *
     */
    private String cpics;

    /**
     * 评论时间
     */
    private Date ctime;

    /**
     * 评论内容
     */
    private String cDesc;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", cpics='" + cpics + '\'' +
                ", ctime=" + ctime +
                ", cDesc='" + cDesc + '\'' +
                '}';
    }
}
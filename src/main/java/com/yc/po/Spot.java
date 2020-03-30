package com.yc.po;

import java.io.Serializable;

/**
 * @author wk
 * @date 2020/3/9  19:53
 */
public class Spot implements Serializable {

    private static final long serialVersionUID = 6392558777745684255L;
    /**
     * 景点编号
     */
    private Integer sid;
    /**
     * 景点名称
     */
    private String sName;

    /**
     * 景点评分
     */
    private String sScore;
    /**
     * 景点价格
     */
    private Double sPrice;

    /**
     * 景点地址
     */
    private String sAddar;

    /**
     * 景点星级
     */
    private Integer sStars;

    /**
     * 景点图片
     */

    private String sPic;

    /**
     * 景点评分人数
     */
    private Integer sNum;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsScore() {
        return sScore;
    }

    public void setsScore(String sScore) {
        this.sScore = sScore;
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public String getsAddar() {
        return sAddar;
    }

    public void setsAddar(String sAddar) {
        this.sAddar = sAddar;
    }

    public Integer getsStars() {
        return sStars;
    }

    public void setsStars(Integer sStars) {
        this.sStars = sStars;
    }

    public String getsPic() {
        return sPic;
    }

    public void setsPic(String sPic) {
        this.sPic = sPic;
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", sScore='" + sScore + '\'' +
                ", sPrice=" + sPrice +
                ", sAddar='" + sAddar + '\'' +
                ", sStars=" + sStars +
                ", sPic='" + sPic + '\'' +
                ", sNum=" + sNum +
                '}';
    }
}

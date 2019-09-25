package com.yc.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Administrator
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 7894196395057249529L;
    private Integer id;

    private String hid;

    private String name;

    private BigDecimal price;

    private String city;

    private String xpath;

    private String ypath;

    private String pic;

    private String addr;

    private String score;

    private String start;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getYpath() {
        return ypath;
    }

    public void setYpath(String ypath) {
        this.ypath = ypath;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hid='" + hid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", xpath='" + xpath + '\'' +
                ", ypath='" + ypath + '\'' +
                ", pic='" + pic + '\'' +
                ", addr='" + addr + '\'' +
                ", score='" + score + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}
package com.yc.po;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 7894196395057249529L;
    private Integer id;

    private String hid;

    private String name;

    private double price;

    private String city;

    private String xpath;

    private String ypath;

    private String pic;

    private String addr;

    private String score;

    private String star;

    public Hotel(String score) {
        this.score = score;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
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
                ", star='" + star + '\'' +
                '}';
    }

    public Hotel(Integer id, String hid, String name, double price, String city, String xpath,
                 String ypath, String pic, String addr, String score, String star) {
        this.id = id;
        this.hid = hid;
        this.name = name;
        this.price = price;
        this.city = city;
        this.xpath = xpath;
        this.ypath = ypath;
        this.pic = pic;
        this.addr = addr;
        this.score = score;
        this.star = star;
    }
    public Hotel(){
        super();
    }
}
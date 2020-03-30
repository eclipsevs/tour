package com.yc.zip.impl;

import com.yc.dao.SpotMapper;
import com.yc.po.Spot;
import com.yc.zip.SpotZip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wk
 * @date 2020/3/9  20:34
 */
@Service
public class SpotZipImpl implements SpotZip {
    @Autowired
    private SpotMapper mapper;

    /**
     * 查询全部景点信息
     * @param request
     * @return
     */
    @Override
    public List<Spot> findAll(HttpServletRequest request) {
        return mapper.findAll(request);
    }

    /**
     * 增加景点
     * @param name 景点名称
     * @param sScore    景点评分
     * @param sPrice    景点价格
     * @param sStars    景点星级
     * @param sPic      景点图片
     * @param sNum      景点评论人数
     * @return
     */
    @Override
    public int add(String name, String sScore, double sPrice, int sStars, String sPic, int sNum) {
        return mapper.add(name, sScore, sPrice, sStars, sPic, sNum);
    }

    /**
     * 增加评论人数
     * @return
     */
    @Override
    public int addSNum() {
        return mapper.addSNum();
    }

    /**
     * 修改评分
     * @param sScore    分数
     * @return
     */
    @Override
    public int alterScore(int sScore) {
        return mapper.alterScore(sScore);
    }

    /**
     * 修改星级
     * @param stars     星级
     * @return
     */
    @Override
    public int alterStars(int stars) {
        return mapper.alterStars(stars);
    }

}

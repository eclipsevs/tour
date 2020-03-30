package com.yc.dao;

import com.yc.po.Spot;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wk
 * @date 2020/3/9  20:44
 */
public interface SpotMapper {
    /**
     * 查询全部景点信息
     *
     * @param request
     * @return
     */
    List<Spot> findAll(HttpServletRequest request);

    /**
     * 增加景点
     * @param sName 景点名称
     * @param sScore    景点评分
     * @param sPrice    景点价格
     * @param sStars    景点星级
     * @param sPic      景点图片
     * @param sNum      景点评论人数
     * @return
     */
    int add(@Param("sName") String sName, @Param("sScore") String sScore, @Param("sPrice") double sPrice, @Param("sStars") int sStars, @Param("sPic") String sPic, @Param("sNum") int sNum);

    /**
     * 增加评论人数
     * @return
     */
    int addSNum();

    /**
     * 修改评分
     * @param sScore    分数
     * @return
     */
    int alterScore(int sScore);

    /**
     * 修改星级
     * @param stars     星级
     * @return
     */
    int alterStars(int stars);
}

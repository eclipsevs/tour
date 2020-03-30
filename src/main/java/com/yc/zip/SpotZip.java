package com.yc.zip;

import com.yc.po.Spot;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wk
 * @date 2020/3/9  20:17
 */
public interface SpotZip {
    /**
     * 查询全部景点信息
     * @param request
     * @return
     */
    List<Spot> findAll(HttpServletRequest request);

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
    int add(String name, String sScore, double sPrice, int sStars, String sPic, int sNum);

    /**
     * 增加评论人数
     * @return  判断是否增加成功
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

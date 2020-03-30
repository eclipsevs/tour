package com.yc.dao;


import java.util.List;

/**
 * @author Administrator
 */
public interface CommentsMapper {
    /**
     * 根据景点ID查询评论
     * @param sid   景点id
     * @return  评论内容
     */
    List<String> findBySid(int sid);

    /**
     * 添加评论
     * @param sid   景点ID
     * @param uid   用户id
     * @param cdesc 评论内容
     * @return
     */
    int addComment(int sid, int uid, String cdesc);
}
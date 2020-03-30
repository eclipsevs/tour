package com.yc.controller;

import com.yc.zip.impl.CommentZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wk
 * @date 2020/3/14  10:48
 */
@Controller
@RequestMapping("/comments")
public class Comments {
    @Autowired
    CommentZipImpl commentZip;

    /**
     * 添加评论
     * @param sid   景点ID
     * @param uid   用户id
     * @param cdesc 评论内容
     * @return
     */
    @RequestMapping("/add")
    int addComment(int sid, int uid, String cdesc) {
        return commentZip.addComment(sid, uid, cdesc);
    }

    /**
     * 根据景点ID查询评论
     * @param sid   景点id
     * @return  评论内容
     */
    @RequestMapping("/findBySid")
    List<String> findBySid(int sid) {
        return commentZip.findBySid(sid);
    }
}

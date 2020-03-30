package com.yc.zip.impl;

import com.yc.zip.CommentZip;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wk
 * @date 2020/3/11  21:37
 */
@Service
public class CommentZipImpl implements CommentZip {
    @Override
    public List<String> findBySid(int sid) {
        return null;
    }

    @Override
    public int addComment(int sid, int uid, String cdesc) {
        return 0;
    }
}

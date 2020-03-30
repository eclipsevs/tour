package com.yc.controller;

import com.yc.po.Spot;
import com.yc.zip.impl.SpotZipImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wk
 * @date 2020/3/10  11:01
 */
@Controller
@RequestMapping("/Spot")
public class SpotController {
    @Autowired
    SpotZipImpl spotZip;


    /**
     * 查询全部景点信息
     * @param request
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Spot> findAll(HttpServletRequest request) {
        return spotZip.findAll(request);
    }
}

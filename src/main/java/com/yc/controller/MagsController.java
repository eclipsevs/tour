package com.yc.controller;

import com.yc.zip.impl.MagImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wk
 * @date 2019/10/4  11:29
 */
@Controller
@RequestMapping("/mags")
public class MagsController {
    @Autowired
    private MagImpl mag;

    @RequestMapping("/send")
    void sendMag(HttpServletRequest request, HttpServletResponse response){
        mag.doMsg(request, response);
    }
}

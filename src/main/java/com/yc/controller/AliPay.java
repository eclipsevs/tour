package com.yc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.yc.zip.impl.AliPayImpl;
import com.yc.zip.impl.AliPayOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wk
 */
@Controller
@RequestMapping("/ali")
public class AliPay {
    @Autowired
    private AliPayImpl aliPay;
    @Autowired
    private AliPayOut aliPayOut;

    /**
     * 支付方法
     *
     * @param response
     * @param count    金额
     * @param id       订单号
     * @return
     * @throws IOException
     */
    @RequestMapping("pay")
    protected String pay(HttpServletResponse response, Double count, String id) throws IOException {
        return aliPay.pay(response, count, id);
    }

    @RequestMapping("/backMoney")
    @ResponseBody
    int backMoney(Integer oid, Double oprice) throws ServletException, IOException {
        return aliPayOut.doGet(oid, oprice);
    }
}

package com.yc.zip.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yc.dao.OrderitemsMapper;
import com.yc.po.Orderitems;
import com.yc.util.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wk
 */
@Service
public class AliPayOut {
    @Autowired
    private OrderitemsMapper mapper;

    public int doGet(Integer oid, Double oprice) throws ServletException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();
        Orderitems orderitems = mapper.findByOid(oid);
        String trade_no = orderitems.getOtcid();
        String refund_amount = oprice.toString();
        //支持部分退款
        String out_request_no = "HZ01RF001";

        req.setBizContent("{\"trade_no\":\"" + trade_no + "\","
                + "\"refund_amount\":\"" + refund_amount + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");
        AlipayTradeRefundResponse resp = null;
        try {
            resp = alipayClient.execute(req);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (resp.isSuccess()) {
            return 1;
        } else {
            System.out.println("调用失败");
            return -1;
        }

    }
}

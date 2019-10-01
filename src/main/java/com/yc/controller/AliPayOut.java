package com.yc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yc.util.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wk
 */
@Controller
@RequestMapping("/ali")
public class AliPayOut{
	@RequestMapping("/out")
	protected int doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获得初始化的AlipayClient
    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();
//	TradePO po = parserRequestToObject(request, TradePO.class);
//	String no = po.getTrade_no();
//	String mn = po.getRefund_amount();
//	String trade_no=no;
//	String refund_amount=mn;
	String out_request_no = "HZ01RF001";
	
//	req.setBizContent("{\"trade_no\":\""+ trade_no +"\","
//            + "\"refund_amount\":\""+ refund_amount +"\","
//            + "\"out_request_no\":\""+out_request_no+"\"}");
	AlipayTradeRefundResponse resp=null;
	try {
		resp = alipayClient.execute(req);
	} catch (AlipayApiException e) {
		e.printStackTrace();
	}
	if(resp.isSuccess()){
	int i =1;
//	toPrintString(response, i);
	return i;
	} else {
	System.out.println("调用失败");
	}
	return -1;
	}
}

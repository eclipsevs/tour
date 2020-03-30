package com.yc.zip.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yc.dao.UserMapper;
import com.yc.po.User;
import org.apache.http.HttpResponse;
import com.yc.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class MagImpl{
	@Autowired
	private UserMapper mapper;

	public void doMsg(HttpServletRequest req, HttpServletResponse resp) {
		//获取当前登录用户信息
		HttpSession session = req.getSession();
		int uid = (int)session.getAttribute("user");
		User user = mapper.findById(uid);
		String tel = user.getUtel();

		//随机生成一个六位数的验证码
		Random random = new Random();
		int num = random.nextInt(899999)+100000;
		String code = new Integer(num).toString();

		String host = "https://dxyzm.market.alicloudapi.com";
		String path = "/chuangxin/dxjk";
		String method = "POST";
		String appcode = "fe22cc5147594a6186a1e7fb5b4cab0b";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("content", "【创信】你的验证码是："+code+"，3分钟内有效！");
		// 测试可用短信模板：【创信】你的验证码是：#code#，3分钟内有效！，如需自定义短信内容或改动任意字符，请联系旺旺或QQ：726980650进行申请。
		querys.put("mobile", tel);
		Map<String, String> bodys = new HashMap<String, String>();

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * pom.xml
			 */
			@SuppressWarnings("unused")
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			//System.out.println(response.toString());
			// 获取response的body
			// System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

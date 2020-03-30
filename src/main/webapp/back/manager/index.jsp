<%@page import="com.yc.po.AdminPO"%>
<%@page import="com.yc.po.SellerPO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
      String path = pageContext.getServletContext().getContextPath();
      path=path+"/";
    
    %>
<base href="<%=path%>">
<title>后台界面</title>

	<link rel="stylesheet" type="text/css" href="back/easyui/css/icon.css" />
	<link rel="stylesheet" type="text/css" href="back/easyui/img/easyui.css" />
	<script type="text/javascript" src="back/easyui/js/jquery.min.js"></script>
	<script type="text/javascript" src="back/easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="back/easyui/js/easyui-lang-zh_CN.js"></script>
	
	
	<style type="text/css">
	ul{
	list-style: none;
	width:150px;
	margin:0px;
	}
	li{
	margin: 0 auto;
	width:148px;
	margin-bottom: 6px;
	}
	</style>
	<%
	SellerPO seller = (SellerPO) session.getAttribute("seller");
	if(null!=seller){
		session.setAttribute("s_id", seller.getS_id());
	}
	
	AdminPO admin = (AdminPO)session.getAttribute("admin");
	%>
</head>
<body class="easyui-layout">
    <div data-options="region:'north'" style="height:80px;"></div>
    <div data-options="region:'south'" style="height:80px;"></div>
    <div data-options="region:'east',title:'East',spilt:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'导航菜单'" style="width:200px;">
       <div id="aa" class="easyui-accordion" data-options="fit:true" style="width:400px;height:500px">
       <%
          if(null!=seller){
       %>
       <!-- 商家处理的超链接 -->
        <div title="商品管理" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/addgood.html">添加商品信息</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/findgood.html">浏览商品信息</a></li>
            </ul>
       </div>
       
       <div title="套餐管理" style="padding: 10px;" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/addgroupbuy.html">添加套餐信息</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/findgroupbuy.html">浏览套餐信息</a></li>
            </ul>
       </div>
       
        <div title="订单管理" style="padding: 10px;" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/findorder.html">浏览订单信息</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/findout.html">退款订单信息</a></li>
            </ul>
       </div>
       
        <div title="商家中心" style="padding: 10px;" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/personal.jsp">个人信息</a></li>
            </ul>
       </div>
       <%
          }else if (null!=admin) {
       %>
       <!-- 管理员超链接 -->
       <div title="类型管理" data-options="selected:true">
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/goodtype.html">商品类型信息</a></li>
            </ul>
       </div>
       
       
       <div title="商家管理" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/findgroupbuy.html">浏览套餐信息</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/showSeller.html">浏览商家信息</a></li>
            </ul>
       </div>
       
        <div title="用户管理" >
            <ul>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/showadmin.html">管理员管理</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="">权限信息</a></li>
            <li><a class="easyui-linkbutton btn" data-options="plain:true" href="back/manager/manSeller.html">商家管理</a></li>
            </ul>
       </div>
       <%
          }
       %>
       <div title="评论管理" style="padding: 10px;">
       </div>
       
       </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
           <div id="show_content" class="easyui-tabs" data-options="fit:true" ></div>
    </div>
</body>

<script type="text/javascript">
$(function () {
	$(".btn").click(function () {
		var href = $(this).attr('href');
		var title=$(this).text();
		if(!$("#show_content").tabs('exists',title)){
			$("#show_content").tabs('add',{
				title:title,
				href:href,
				closable:true,
				tools:[{
					iconCls:'icon-mini-refresh',
					handler:function(){
						alert('refresh');
					}
				}]
			});
		}else{
			$("#show_content").tabs('select',title);
		}
		return false;
	});
});
</script>
</html>
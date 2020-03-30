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
<title>Insert title here</title>
    
    <link rel="stylesheet" type="text/css" href="back/easyui/css/icon.css" />
	<link rel="stylesheet" type="text/css" href="back/easyui/img/easyui.css" />
	<script type="text/javascript" src="back/easyui/js/jquery.min.js"></script>
	<script type="text/javascript" src="back/easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="back/easyui/js/easyui-lang-zh_CN.js"></script>
	
</head>
<body>

<table id="show_seller"></table>
<input type="button" onclick="updateState(sid)" style="width:100px;height:50px;margin-top:30px;
margin-left:45%;" value="提交"/>
<script type="text/javascript">
$(function(){
	$('#show_seller').datagrid(
			
			{
				url : 'seller.action',
				queryParams : {
					op : 'find',
					s_id : '<%=session.getAttribute("s_id")%>'
				},
				onClickCell: onClickCell,
			    onAfterEdit:onAfterEdit,
			    fitColumns:'true',
			    singleSelect:true,
				toolbar:[{
					iconCls:'icon-edit',
					handler:function(){
						
					}
				}],
				columns : [ [
						{
							
							field : 's_id',
							title : '商家编号',
							width : 100,
							align : 'center',
						},
						{
							field : 's_name',
							title : '商家账号',
							width : 100,
							align : 'center',
							editor: 'text',
							
						},
						{
							field : 's_pwd',
							title : '商家密码',
							width : 100,
							align : 'center',
							editor: 'text',
							formatter : function(value, row, index) {
								return '******';
							}
						},
						{
							field : 's_tel',
							title : '商家手机号',
							width : 100,
							align : 'center',
							editor: 'text',
						},
						{
							field : 's_licence',
							title : '营业执照',
							width : 100,
							align : 'center',
							formatter : function(value, row, index) {
									return '<img src='+value+' style=width:80px;height:80px;>';
							}
						},
						{
							field : 's_addr',
							title : '商家地址',
							width : 100,
							align : 'center',
							editor: 'text',
						},
						{
							field : 's_pic',
							title : '商家照片',
							width : 100,
							align : 'center',
							formatter : function(value, row, index) {
								return '<img src='+value+' style=width:80px;height:80px;>';
						}
						},
						
						{
							field : 's_state',
							title : '账号状态',
							width : 100,
							align : 'center',
							formatter : function(value, row, index) {
								if (value == 1) {
									return '待审核';
								} else if(value==2){
									return '可用';
								}else{
									return '禁用';
								}
							}
						}] ]
			});
});
	function updateState(sid) {
		$.get("seller.action",{op:'update',s_id:sid},function(data){
			if(data==1){
				$.messager.show({
					title:'温馨提示',
					msg:'修改成功',
					timeout:4000,
					showType:'slide'
				});
				$('#show_seller').datagrid('reload');
			}else {
				$.messager.alert('错误提示','修改失败');
			}
		});
	}
	
	var editIndex = undefined;
	function endEditing() {//该方法用于关闭上一个焦点的editing状态
		if (editIndex == undefined) {
			return true
		}
		if ($('#show_seller').datagrid('validateRow', editIndex)) {
			$('#show_seller').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	//点击单元格事件：
	function onClickCell(index,field,value) {
		if (endEditing()) {
			if(field=="s_addr"){
				$(this).datagrid('beginEdit', index);
				var ed = $(this).datagrid('getEditor', {index:index,field:field});
				$(ed.target).focus();
			}		
			editIndex = index;
		}
	
	}
	//单元格失去焦点执行的方法
	function onAfterEdit(index, row, changes) {
		var updated = $('#show_seller').datagrid('getChanges', 'updated');
		if (updated.length < 1) {
			editRow = undefined;
			$('#show_seller').datagrid('unselectAll');
			return;
		} else {
			// 传值
			submitForm(index, row, changes);
		}
	}
	function submitForm(index, row, changes) {
		var s_id = row.s_id;
		var s_name = row.s_name;
		var s_tel = row.s_tel;
		var s_pwd = row.s_pwd;
		var s_addr = row.s_addr;
		var s_pic = row.s_pic;
		 $.post("seller.action",{op:'updatep',s_id:s_id,s_name:s_name,s_tel:s_tel,s_pwd:s_pwd,s_addr:s_addr,s_pic:s_pic},
                function(data) {
				if(data==1){
					//alert("保存成功");
					$("#show_seller").datagrid('reload');
				}
			});
	}
	 

	
</script>
</body>

</html>
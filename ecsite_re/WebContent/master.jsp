<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<title>MSTER画面</title>
	<style type="text/css">
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helvetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff
		}
		table{
			text-align:center;
			margin:0 auto;
		}
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
			font
		}
		#header{
			width:100%;
			height:80px;
			background-color:silver;
		}
		#main{
			width:100%;
			height:500px;
			text-align:center;
		}
		#footer{
			width:100%;
			height:80px;
			background-color:silver;
			clear:both;
		}
	</style>
	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);
			$('form').submit();
		}
	</script>

	</head>
	<body>
		<div id="header">
			<div id="pr"></div>
		</div>
		<div id="main">
			<div id="top"><p>管理者画面</p></div>
			<div>
				<p><a href='<s:url action="UserListAction"/>'>ユーザー一覧</a></p>
				<br>
				<div>
				<s:form>
					<input type="button" value="ユーザー登録" onclick="submitAction('UserCreateAction')" />
					<input type="button" value="ユーザー削除" onclick="submitAction('UserDeleteAction')" />
					<input type="button" value="ユーザー更新" onclick="submitAction('UserUpdateAction')" />
				</s:form>
				</div>
				<br>
				<p><a href='<s:url action="ItemListAction"/>'>商品一覧</a></p>
				<br>
				<s:form>
					<input type="button" value="商品データ登録" onclick="submitAction('ItemCreateAction')" />
					<input type="button" value="商品データ削除" onclick="submitAction('ItemDeleteAction')" />
					<input type="button" value="商品データ更新" onclick="submitAction('ItemUpdateAction')" />
				</s:form>
			</div>
		</div>
		<div id="footer">
			<div id="pr"></div>
		</div>
	</body>
</html>
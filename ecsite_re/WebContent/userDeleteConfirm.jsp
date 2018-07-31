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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	</script>
	<title>UserDeleteConfirm画面</title>

	<style type="text/css">
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helvetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}
		table{
			text-align:center;
			margin:0 auto;
		}
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}
		#header{
			width:100%;
			height:80px;
			background-color:black;
		}
		#main{
			width:100%;
			height:500px;
			text-align:center;
		}
		#footer{
			width:100%;
			height:80px;
			background-color:black;
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
			<div id="top"><p>確認画面</p></div>
			<div>
				<s:if test="message == null">
				<p>以下のユーザーデータを削除します。</p>
				<s:form>
					<tr>
						<td>ユーザID：</td>
						<td><s:property value="session.loginId" /></td>
					</tr>
					<tr>
						<td>パスワード：</td>
						<td><s:property value="session.loginPass" /></td>
					</tr>
					<tr>
						<td>ユーザー名：</td>
						<td><s:property value="session.userName" /></td>
					</tr>
					<tr>
						<td><br></td>
					</tr>
					</s:form>
					<s:form action="UserListAction">
						<input type="hidden" name="deleteFlg" value="1" >
						<s:submit value="削除" method="delete" />
					</s:form>
					<s:form action="UserDeleteAction">
						<s:submit value="キャンセル"/>
					</s:form>
				</s:if>
				<s:elseif test="message != null">

					<h3><s:property value="message" /></h3>
					<s:form action="UserDeleteAction">
						<s:submit value="戻る"/>
					</s:form>
					<p><br></p>
					<a href='<s:url action="LoginAction"/>'>Homeへ</a>

				</s:elseif>
			</div>
		</div>
		<div id="footer">
			<div id="pr"></div>
		</div>

	</body>
</html>
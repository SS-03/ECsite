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

	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	</script>
	<title>UserList画面</title>

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
			<div id="top"><p>ユーザー一覧</p></div>
			<div>
				<table>
					<tr>
						<th>ユーザーID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>
					<s:iterator value="userList">
					<tr>
						<td><s:property value="loginId" /></td>
						<td><s:property value="loginPassword" /></td>
						<td><s:property value="userName" /></td>
						<td><s:property value="insertDate" /></td>
						<td><s:property value="updatedDate" /></td>
					</tr>
					</s:iterator>
				</table>
				<p><br></p>



			</div>
		</div>
		<div id="footer">
			<div id="pr"></div>
		</div>

	</body>
</html>
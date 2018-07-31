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
	<title>UserDelete画面</title>


	<%-- <script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);

			$('form').submit();
		}
	</script> --%>
	</head>
	<body>
		<div id="header">
			<div id="pr"></div>
		</div>
		<div id="main">
			<div id="top"><p>ユーザー削除</p></div>
			<div>
				<h3>削除するユーザーデータを選択してください。</h3>
				<s:form>
				<table>
					<tr>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>
					<s:iterator value="userList">
<!-- onclick='submitAction("UserDeleteConfirmAction")' -->
						<tr>
							<td><a href='<s:url action="UserDeleteConfirmAction">
									<s:param name="id" value="%{id}" /> </s:url>'>
									<s:property value="loginId" /></a></td>
							<td><s:property value="loginPassword" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="insertDate" /></td>
							<td><s:property value="updatedDate" /></td>
						</tr>

					</s:iterator>
				</table>
				</s:form>
			</div>
		</div>
		<div id="footer">
			<div id="pr"></div>
		</div>

	</body>
</html>
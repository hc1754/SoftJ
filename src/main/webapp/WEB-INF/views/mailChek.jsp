<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h4>인증번호 체크</h4>


		<form action="${pageContext.request.contextPath}/mail/mailChecking"
			method="post">
			<div align="center">
				<!-- 인증번호 -->
				<input type="text" name="number" size="120" style="width: 100%"
					placeholder="인증번호를 입력해주세요" class="form-control">
			</div>
			<div align="center">
				<input type="submit" value="확인" class="btn btn-warning">
			</div>
		</form>


		<table border="1">
			<thead>
				<tr>
					<th>인증번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.email_num}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
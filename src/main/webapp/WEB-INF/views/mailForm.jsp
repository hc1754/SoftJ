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
  <h4>메일 보내기</h4>
  <form action="${pageContext.request.contextPath}/mail/mailSending" method="post">
    <div align="center"><!-- 받는 사람 이메일 -->
      <input type="text" name="tomail" size="120" style="width:100%" placeholder="인증받을 이메일을 입력해주세요" class="form-control" >
    </div>     
    <div align="center"><!-- 제목 -->
      <input type="text" style="border:0" name="title" size="120" style="width:100%" class="form-control" >
    </div>
    <p>
    <div align="center"><!-- 내용 --> 
      <input type="text" style="border:0" name="content" size="120" style="width:100%" class="form-control" >
    </div>
    <p>
    <div align="center">
      <input type="submit" value="메일 보내기" class="btn btn-warning">
    </div>
  </form>
</div>
</body>
</html>
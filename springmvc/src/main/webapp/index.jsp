<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Insert title here</title>
</head>
<body>
<div>
  <!--表单会被SpringSecurity拦截，进入manager-->
  <!--必须要使用post提交表单的方式-->
  <form action="user/login" method="post">
    用户名：<input type="text" name="username" /><br/>
    密  码：<input type="text" name="password" /><br/>
    <button type="submit">登录</button>
  </form>
</div>
</body>
</html>

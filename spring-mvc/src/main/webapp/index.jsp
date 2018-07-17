<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath }/testSimpleJsonWithAjax.jsp">testSimpleJsonWithAjax</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjax.jsp">testJsonListWithAjax</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjaxNonForm.jsp">非表单的 Ajax 提交</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjaxForm.jsp">基于表单的 Ajax 提交</a> <br>

</body>
</html>

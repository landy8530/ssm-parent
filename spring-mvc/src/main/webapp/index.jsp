<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath }/testSimpleJsonWithAjax.jsp">testSimpleJsonWithAjax</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjax.jsp">testJsonListWithAjax</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjaxNonForm.jsp">非表单的 Ajax 提交</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjaxForm.jsp">基于表单的 Ajax 提交(使用 serializeObject()序列化,通过SpringMVC自身进行处理)</a> <br>
<a href="${pageContext.request.contextPath }/testJsonListWithAjaxFormThirdParty.jsp">基于表单的 Ajax 提交(使用 serializeObject()序列化,引入第三方 Jar 包进行处理)</a> <br>

<a href="${pageContext.request.contextPath }/testJsonListWithAjaxFormSerializePage.do">基于表单的 Ajax 提交(使用 serialize()序列化)</a> <br>
<a href="${pageContext.request.contextPath }/complexDataPage.do">复杂数据处理</a> <br>
<a href="${pageContext.request.contextPath }/complexDataWithSerializePage.do">复杂数据处理(使用 serialize()序列化)</a> <br>

</body>
</html>

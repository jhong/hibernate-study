<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="net.study.code.CodeVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>코드 상세</title>
<script type="text/javascript">
<!--
/*
 * 등록
 */
function doRegist() {

	var form = document.forms["subForm"];
	form.submit();
}

/*
 * 수정
 */
function doModify() {

	var form = document.forms["subForm"];
	form.submit();
}

/*
 * 삭제
 */
function doDelete() {

	var form = document.forms["deleteForm"];
	form.submit();
}

//-->
</script>
</head>
<body>
code_edit.jsp
<br/>
<%
CodeVo codeVo = (CodeVo)request.getAttribute("codeVo");
out.print("codeVo : "+codeVo);

String formMethod = "POST";
if (codeVo != null && codeVo.getCode() != null && !"".equals(codeVo.getCode())) formMethod = "PUT";
%>
<hr/>
<form:form commandName="codeVo" id="subForm" name="subForm" method="<%=formMethod%>" action="${pageContext.request.contextPath}/codes">

<ul>
	<li>codecategorykey : <input type="text" name="codecategorykey" value="<%=codeVo.getCodecategorykey()%>"/></li>
	<li>code : <form:input path="code" /></li>
	<li>codeexplain : <form:input path="codeexplain" size="50"/></li>
	<li>codename : <form:input path="codename" size="50"/></li>
	<li>codeengname : <form:input path="codeengname" size="50"/></li>
	<li>status : <form:input path="status" /></li>
</ul>

</form:form>

<hr/>
<a href="#" onclick="doRegist();">[등록]</a>
<a href="#" onclick="doModify();">[수정]</a>

<%
if (codeVo != null) {
%>
<form:form commandName="codeVo" id="deleteForm" name="deleteForm" method="DELETE" action="${pageContext.request.contextPath}/codes/${codeVo.code}">
</form:form>
<a href="#" onclick="doDelete();">[삭제]</a>
<%
}
%>

<a href="${pageContext.request.contextPath}/codes?codecategorykey=TEST">[목록으로]</a>

</body>
</html>

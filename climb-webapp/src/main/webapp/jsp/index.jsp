<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<h2>Hello World!</h2>
	
<s:url value="login">
    <s:param name="id" value="txt"/>
</s:url>

<%@ include file="_include/footer.jsp"%>

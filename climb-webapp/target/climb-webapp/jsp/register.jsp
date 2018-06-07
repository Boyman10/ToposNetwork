<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Registration form</h2>

	<p>Please register to get access</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>

	<s:form action="register" method="post" validate="true">
		<s:textfield key="username" name="userBean.username" />
		<s:textfield key="email" name="userBean.email" />
		<s:password key="password" name="userBean.password" />
		<s:password key="confirm" name="confirm" />
		<s:submit value="Submit" />
		<%-- add token to JSP to be used by Token interceptor --%>
		<s:token />
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

</div>


<%@ include file="../_include/_scripts.jsp"%>

<%@ include file="_include/footer.jsp"%>

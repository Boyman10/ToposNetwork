<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Login form</h2>
	
	<p>Please login now</p>

	<s:form action="login">
			<s:textfield name="userBean.pseudo" label="Your login name" />
			<s:password name="password" label="Your password" />
			<s:submit value="Submit" />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="welcome">
				<s:actionmessage />
			</div>
		</s:if>

</div>




<%@ include file="_include/footer.jsp"%>
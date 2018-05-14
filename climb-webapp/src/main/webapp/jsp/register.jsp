<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Registration form</h2>
	
	<p>Please register to get access</p>

	<s:form action="register">
			<s:textfield name="userBean.username" label="Your login name" class="form-control"/>
			<s:textfield name="userBean.email" label="Your email" class="form-control" />
			<s:password name="userBean.password" label="Your password" class="form-control" />
			
			<s:submit value="Submit" class="btn btn-primary" />
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




<%@ include file="_include/footer.jsp"%>/html>
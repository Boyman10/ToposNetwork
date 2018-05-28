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
	<s:else>
		<s:form action="register">
			<s:textfield key="userBean.username" class="form-control" />
			<s:textfield key="userBean.email" class="form-control" />
			<s:password key="userBean.password" class="form-control" />

			<s:submit value="Submit" class="btn btn-primary" />
			<%-- add token to JSP to be used by Token interceptor --%>
			<s:token />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
	</s:else>

</div>




<%@ include file="_include/footer.jsp"%>

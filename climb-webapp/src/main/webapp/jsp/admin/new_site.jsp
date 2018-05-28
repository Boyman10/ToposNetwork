<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Adding a new Site</h2>

	<p>
		You are allowed access to add new Site details here - 
		The next step will be adding new area and routes. 
		You may come back later here to access the different functionalities.
	</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
	<s:else>
		<s:form action="new_site">
			<s:textfield key="userBean.username" class="form-control" />
			<s:textfield key="userBean.email" class="form-control" />
			<s:password key="userBean.password" class="form-control" />

			<s:submit value="Submit" class="btn btn-primary" />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
	</s:else>

</div>

<%@ include file="../_include/footer.jsp"%>
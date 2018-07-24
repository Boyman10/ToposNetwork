<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Adding a new Route</h2>

	<p>You are allowed access to add new route details here.</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
	<s:else>
		<s:form action="new_route">
			<s:textfield key="routeBean.name" />
			<s:textfield key="routeBean.summit" />
			<s:textfield key="routeBean.nbPoints" />
			<s:textarea key="routeBean.details" />
			
			<s:select key="grade" list="{}" id="grades" listKey="id" />
			<s:select key="area" list="{}" id="areas" listKey="id" />

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
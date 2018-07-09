<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Editing a Site</h2>

	<p>You are allowed access to edit Site details here.</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
	<s:else>
		<s:form action="site">
			<s:textfield key="siteBean.name"  class="form-control" />
			<s:textfield key="siteBean.type"  class="form-control" />
			<s:textfield key="siteBean.location"  class="form-control" />
			<s:textfield key="siteBean.region" class="form-control" />
			<s:textfield key="siteBean.department"  class="form-control" />
			<s:textfield key="siteBean.country" class="form-control" />
			
			<s:hidden key="siteBean.id" />
			<s:submit value="Submit" class="btn btn-primary" />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
	</s:else>

</div>
<%@ include file="../_include/_scripts.jsp"%>
<%@ include file="../_include/footer.jsp"%>
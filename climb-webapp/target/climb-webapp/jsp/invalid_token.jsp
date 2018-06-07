<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Eh dude !</h2>

	<div class="alert alert-info" role="alert">
		<h3>User information is not updated, duplicate request detected.</h3>
		<h4>Possible Reasons are:</h4>
		<ul>
			<li>Back button usage to submit form again</li>
			<li>Double click on Submit button</li>
			<li>Using "Reload" Option in browser</li>
		</ul>
		<br>
		<s:if test="hasActionErrors()">
			<s:actionerror />
		</s:if>
	</div>

</div>
<%@ include file="../_include/_scripts.jsp"%>
<%@ include file="_include/footer.jsp"%>



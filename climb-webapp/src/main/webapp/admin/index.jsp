<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Admin interface</h2>

	<p>This page shows you several links to add information to the
		community website</p>

	<p><s:a namespace="/admin" action="profile">See my profile</s:a></p>

</div>
<%@ include file="../_include/_scripts.jsp"%>
<%@ include file="../_include/footer.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h1>My Profile</h1>

	<p>You may modify your personals at any time</p>

	<div class="jumbotron">
		<h2 class="display-4">
			<s:property value="user.username" />
		</h2>
		<p class="lead"><div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action"><s:property value="user.datereg" /></a>
			  <a href="#" class="list-group-item list-group-item-action list-group-item-primary"><s:property value="user.email" /></a>
			  <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><s:property value="user.role" /></a>
			</div>
					
		</p>
		
		<hr class="my-4">
		<p>It uses utility classes for typography and spacing to space
			content out within the larger container.</p>
		<p class="lead">
			<a class="btn btn-primary btn-lg" href="#" role="button">Upload a new Picture</a>
		</p>
	</div>


</div>
<%@ include file="../_include/_scripts.jsp"%>
<%@ include file="../_include/footer.jsp"%>

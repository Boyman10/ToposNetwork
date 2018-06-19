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


		<div class="row lead">
			<div class="col">
			<s:property value="user.gravatar" />
			</div>
			<div class="col">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action"><s:property
							value="user.datereg" /></a> <a href="#"
						class="list-group-item list-group-item-action list-group-item-primary"><s:property
							value="user.email" /></a> <a href="#"
						class="list-group-item list-group-item-action list-group-item-secondary"><s:property
							value="user.role" /></a>
				</div>
			</div>
			


		</div>


		<hr class="my-4">
		<p>Here you will be able to add new pictures later on - for now just a tool to upload a gravater.</p>
		<p class="lead">
				<%@ include file="../_include/_modal.jsp"%>

		</p>
	</div>


</div>
<%@ include file="../_include/_scripts.jsp"%>
<script type="text/javascript" src="/climb-webapp/assets/js/gravatar.js"></script>
<%@ include file="../_include/footer.jsp"%>

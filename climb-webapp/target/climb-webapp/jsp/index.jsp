<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Welcome dude !</h2>

	<div class="alert alert-info" role="alert">

		<s:if test="#session.user">
            Utilisateur connecté :
            <s:property value="#session.user.username" />

			<s:a action="logout">Déconnexion</s:a>
		</s:if>
		<s:else>
			<s:a action="login">Connexion</s:a>
		</s:else>
	</div>
</div>

<%@ include file="_include/footer.jsp"%>

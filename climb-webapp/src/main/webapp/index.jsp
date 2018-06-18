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

			<s:a namespace="public" action="logout">Déconnexion</s:a>
		</s:if>
		<s:else>
			<s:a namespace="public" action="login">Connexion</s:a>
		</s:else>
	</div>



	<%@ include file="_include/_modal.jsp"%>
</div>

<%@ include file="_include/_scripts.jsp"%>

<script type="text/javascript" src="assets/js/gravatar.js"></script>

<%@ include file="_include/footer.jsp"%>		

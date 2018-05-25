<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Gravatar upload</h3>

<!-- Check whether we are connected or not -->
<s:if test="#session.user">

	<s:if test="#session.user.gravatar">
		<img src="<s:property value="#session.user.gravatar" />" />
	</s:if>
	
	<s:else>
	
	
	</s:else>
	
</s:if>
<s:else>
	<s:a action="login">Please do login first !</s:a>
</s:else>

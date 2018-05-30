<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Contact form</h2>

	<p>Fill the form and click the button to contact us</p>
	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
		<s:form action="contact" method="post" validate="true">
			<s:textfield name="contactEmail" key="email" />
			<s:textfield name="contactSubject" key="subject" />
			<s:textarea key="message" name="contactMessage" />
			<%-- add token to JSP to be used by Token interceptor --%>
			<s:token />
			<s:submit value="Send" />

		</s:form>


	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>

	</s:if>

</div>




<%@ include file="_include/footer.jsp"%>

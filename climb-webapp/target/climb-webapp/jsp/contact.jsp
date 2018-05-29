<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Contact form</h2>
	
	<p>Fill the form and click the button to contact us</p>

	<s:form action="contact" method="post">
			<s:textfield name="contactEmail" key="email" label="Your email" class="form-control"/>
			<s:textfield name="subject" label="Your subject" class="form-control"/>
			<s:textarea name="message" label="Message" class="form-control"/>
			
			<s:submit value="Send" class="btn btn-primary" />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="welcome">
				<s:actionmessage />
			</div>
		</s:if>

</div>




<%@ include file="_include/footer.jsp"%>

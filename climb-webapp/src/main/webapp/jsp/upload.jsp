<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="_include/head.jsp"%>
<%@ include file="_include/header.jsp"%>


<div class="container">

	<h2>Upload form sample</h2>

	<p>Multiple file upload... with dynamic entries using Jquery</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />

			<s:if test="filename">
				<s:url var="url" value="/img/test.gif" />
				<img src="<s:property value="filesPath"/>/<s:property value="filename"/>" border="0" alt="My uploaded image">
			</s:if>
		</div>
	</s:if>
	<s:else>
		<s:form action="upload" method="post" enctype="multipart/form-data"
			id="formGravatar">
			<div class="form-group">
				<s:file name="uploadFile" label="Your File"
					class="form-control-file" id="gravatar" />

				<button type="submit" class="btn btn-primary" id="subGravatar">Submit</button>
			</div>
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
	</s:else>


</div>




<%@ include file="_include/footer.jsp"%>

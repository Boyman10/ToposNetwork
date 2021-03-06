<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Upload form sample</h2>

	<p>Multiple file upload... with dynamic entries using Jquery</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />

			Check out your file :<br/>
				<img src="<s:url action='showImage?imageId=create-a-gravatar-beard.png' />" border="0" alt="My uploaded image">
		</div>
	</s:if>
	<s:else>
		<s:form namespace="public" action="upload" method="post" enctype="multipart/form-data"
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


<%@ include file="../_include/_scripts.jsp"%>
<%@ include file="../_include/footer.jsp"%>

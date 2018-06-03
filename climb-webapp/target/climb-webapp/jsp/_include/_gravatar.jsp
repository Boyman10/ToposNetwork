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

		<p>Please pick up your gravatar now :</p>

		<s:form action="gravatar" method="post" enctype="multipart/form-data" id="formGravatar">
			<div class="form-group">
				<s:file name="uploadFile" label="Your File" class="form-control-file"
					id="gravatar" />

				<button type="submit" class="btn btn-primary" id="subGravatar">Submit</button>
			</div>
		</s:form>




	</s:else>

</s:if>
<s:else>
	<s:a action="login">Please do login first !</s:a>
</s:else>

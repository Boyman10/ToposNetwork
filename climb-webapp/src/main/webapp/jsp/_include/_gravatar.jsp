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

		<div class="form-group">
			<s:file name="upload" label="Your File" class="form-control-file" id="gravatar"/>
      
			<label for="gravatar">Your file</label> 
			<input type="file" class="form-control-file" id="gravatar" name="upload">
			 <button type="submit" class="btn btn-primary" id="subGravatar">Submit</button>
		</div>
		


		<script>
			$.{"#subGravatar"}.onClick()
		</script>



	</s:else>

</s:if>
<s:else>
	<s:a action="login">Please do login first !</s:a>
</s:else>

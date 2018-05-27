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


		<script>
		$(document).ready(function () {
			//https://www.mkyong.com/jquery/jquery-ajax-submit-a-multipart-form/
		
			
			$("#subGravatar").click(function(event){
				console.log("Click on BTN...");
				
		        //stop submit the form, we will post it manually.
		        event.preventDefault();

		        // Get form
		        var form = $('#formGravatar')[0];

				// Create an FormData object 
		        var data = new FormData(form);

				// If you want to add an extra field for the FormData
		        data.append("CustomField", "This is some extra data, testing");

				// disabled the submit button
		        $("#btnSubmit").prop("disabled", true);

				form.append('<i class="fa fa-spinner" aria-hidden="true"></i>');
				
		        $.ajax({
		            type: "POST",
		            enctype: 'multipart/form-data',
		            url: "/climb-webapp/gravatar.action",
		            data: data,
		            processData: false,
		            contentType: false,
		            cache: false,
		            timeout: 600000,
		            success: function (data) {

		                $("#result").text(data);
		                console.log("SUCCESS : ", data);
		                $("#subGravatar").prop("disabled", false);

		            },
		            error: function (e) {

		                $("#result").text(e.responseText);
		                console.log("ERROR : ", e);
		                $("#subGravatar").prop("disabled", false);

		            }
		        });

		    });
		
		});	
		</script>



	</s:else>

</s:if>
<s:else>
	<s:a action="login">Please do login first !</s:a>
</s:else>

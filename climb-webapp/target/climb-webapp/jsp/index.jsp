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

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
				<%@ include file="_include/_gravatar.jsp"%>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../_include/_scripts.jsp"%>

<script type="text/javascript">		

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
		        data.append("sourceToken", "This is some extra data, token to implement ?");

				// disabled the submit button
				
				 $(this).removeClass();
				    $(this).addClass('fa fa-spinner fa-spin');
				    setTimeout(function() { $('.fa').removeClass().addClass('fa fa-minus-circle') }, 1000);

				
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

		            	console.log("Receiving data : " , data);
		            	$.each(data, function (key, val) {
		            		
		            		console.log("SUCCESS key : ", key , " and val : ", val );
		            		
		                });
		                
		                

		            },
		            error: function (e) {
		                console.log("ERROR : ", e);

		            }
		        });

		    });
		
		});	
		</script>

<%@ include file="_include/footer.jsp"%>		

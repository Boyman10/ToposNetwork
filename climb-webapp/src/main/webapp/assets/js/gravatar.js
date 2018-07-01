
$(document).ready(function () {
	//https://www.mkyong.com/jquery/jquery-ajax-submit-a-multipart-form/

	// first hiding the alert box :
	$("div#gravatar-msg").hide();
	
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
            success: function (data) { // here the function when everything goes fine :

            	console.log("Receiving data : " , data);
            	/*
            	$.each(data, function (key, val) {
            		
            		console.log("SUCCESS key : ", key , " and val : ", val );
            		
                });
                
                */
            	// Hide the form :
            	$("form#formGravatar").hide();
            	
            	// Display the message and gravatar :
            	$("div#gravatar-msg").show();
            	$("div#gravatar-msg").append("The gravatar has been uploaded successfully !");

            },
            error: function (e) {
                console.log("ERROR : ", e);

            }
        });

    });

});	
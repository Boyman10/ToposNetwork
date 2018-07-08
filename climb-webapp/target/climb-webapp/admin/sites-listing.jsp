<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Admin interface</h2>

	<p>Retrieve here the sites listing and access their relative areas and routes...</p>


	<ul class="list-group" id="sites">
		

	</ul>

</div>
<%@ include file="../_include/_scripts.jsp"%>

<s:url action="site.action" namespace="/admin" var="urlTag" ></s:url>

<script type="text/javascript">
	// Once doc is ready
	$(document).ready(
			function(event) {

				// On document load, we launch the ajax request to load all sites entries :
				var url = "<s:url action="sites" />";

				console.log("We are loading now...");

				// Action AJAX using POST
				jQuery.post(
						url,
						[],
						function(data) {
							var $sites = jQuery("#sites");
							$sites.empty();

							jQuery.each(data, function(key, val) {
								
								var siteUrl = '<a href="<s:property value="#urlTag" />"?id=' + data['id'] + '>' + data['name'] + '</a>' ;
							    				
								$sites.append("<li class=\"list-group-item\">" + siteUrl  + "</li>");
							});
						}).fail(function(data) {
					if (typeof data.responseJSON === 'object') {
						console.log(data.responseJSON);
					} else {
						console.log(data);
					}
					alert("Error loading sites !");
							});
						
			});
</script>

<%@ include file="../_include/footer.jsp"%>
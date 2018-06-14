<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../_include/head.jsp"%>
<%@ include file="../_include/header.jsp"%>


<div class="container">

	<h2>Adding a new Area</h2>

	<p>You are allowed access to add new area details here - The next
		step will be adding new routes. You may come back later here to access
		the different functionalities.</p>

	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
	<s:else>
		<s:form action="new_area">
			<s:textfield key="areaBean.name" />
			<s:textarea key="areaBean.details" />
			<s:select key="siteId" list="{}" id="sites" listKey="id" />

			<button class="btn btn-info" id="load">Load sites</button>

			<s:submit value="Submit" class="btn btn-primary" />
		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
	</s:else>

</div>


<%@ include file="../_include/_scripts.jsp"%>


<script type="text/javascript">
	// Once doc is ready
	$(document).ready(
			function() {

				// On button click, we load the ajax request to load all sites entries :
				var url = "<s:url action="sites" />";

				$("#load").click (
						function(event) {

							event.preventDefault();
							console.log("We are loading now...");

							// Action AJAX en POST
							jQuery.post(
									url,
									[],
									function(data) {
										var $sites = jQuery("#sites");
										$sites.empty();

										jQuery.each(data, function(key, val) {
											$sites
													.append(jQuery("<option>")
															.text(val.name)
															.val(val.id));
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
			});
</script>

<%@ include file="../_include/footer.jsp"%>
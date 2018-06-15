<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	
	
<footer class="footer">
	<div class="container">
		<p>
		<hr />
		<s:text name="contact" />
		<s:text name="application.name" /> - version ${project.version} &copy; 
		<s:text name="organization.url" />
		 - <s:a action="contact_form">Contact us</s:a>
		</p>
		
		<a href="${organization.url}">${organization.name}</a>
	</div>
</footer>

<s:debug />

</body>
</html>
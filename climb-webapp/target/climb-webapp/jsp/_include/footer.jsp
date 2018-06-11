<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ page isELIgnored="false"%>
	
<footer class="footer">
	<div class="container">
		<p>
		<hr />
		<s:text name="contact" />
		<s:text name="application.name" /> - version 0.0.1-SNAPSHOT &copy; 
		<s:text name="organization.url" />
		 - <s:a action="contact_form">Contact us</s:a>
		</p>
		
		<a href="https://r-h-m.net">RHM</a>
	</div>
</footer>

<s:debug />

</body>
</html>
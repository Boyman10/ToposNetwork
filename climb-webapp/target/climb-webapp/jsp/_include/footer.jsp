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
		 - <s:a action="contact">Contact us</s:a>
		</p>
	</div>
</footer>

<s:debug />

<!-- 

<s:component template="/footer.ftl" label="Zip+4">
        <s:param name="zipName" value="%{'zip'}" />
        <s:param name="zipValue" value="%{zip}" />
        <s:param name="plus4Name" value="%{'plus4'}" />
        <s:param name="plus4Value" value="%{plus4}" />
    </s:component>
-->
<!-- Bootstrap -->
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Climb me</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <s:a namespace="/" action="index" title="home" cssClass="nav-link">Home <span class="sr-only">(current)</span></s:a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <s:text name="authentication" />
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        
        <s:if test="#session.user">
			<s:a namespace="/public" action="logout" title="logout" cssClass="dropdown-item nav-link">Logout</s:a>
        </s:if>
        <s:else>
          <s:a namespace="/public" action="login" title="login" cssClass="dropdown-item nav-link">Login</s:a>
          <s:a namespace="/public" action="register_form" title="register" cssClass="dropdown-item nav-link">Register</s:a>       
        
       	 
        </s:else>

          <div class="dropdown-divider"></div>
          <s:a namespace="/public" action="contact_form" title="Contact us" cssClass="dropdown-item nav-link">Contact</s:a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <s:text name="tools" />
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <s:a namespace="/public" action="upload" title="Upload files" cssClass="dropdown-item nav-link">Uploads files</s:a>
          <div class="dropdown-divider"></div>
          <s:a namespace="/public" action="contact_form" title="Contact us" cssClass="dropdown-item nav-link">Contact</s:a>
        </div>
      </li>      
      <li class="nav-item dropdown">
      
      <s:if test="#session.user">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <s:text name="administration" />
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        	<s:a namespace="/admin" action="admin" title="Administrative interface" cssClass="nav-link"><s:text name="board" /></s:a>
        	<div class="dropdown-divider"></div>
        	<s:a namespace="/admin" action="new_site" title="Add new Site" cssClass="dropdown-item nav-link">Add new site</s:a>
        	<s:a namespace="/admin" action="new_area" title="Add new Area" cssClass="dropdown-item nav-link">Add new area</s:a>
        	<s:a namespace="/admin" action="new_route" title="Add new Route" cssClass="dropdown-item nav-link">Add new route</s:a>
        	<div class="dropdown-divider"></div>
        	<s:a namespace="/admin" action="add_grade" title="Add new Grade" cssClass="dropdown-item nav-link">Add new grade</s:a>
        </div>
       </s:if>
       <s:else>
       	<s:a namespace="/admin" action="admin" title="Administrative interface" cssClass="nav-link disabled"><s:text name="administration" /></s:a>
       </s:else>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
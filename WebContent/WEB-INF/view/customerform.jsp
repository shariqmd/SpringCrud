<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="empform">Add Employee</a>
<a href="viewform">View Employee</a>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Crud</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Customer Form</h2> <hr />
   
  <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Customer</div>
    </div>
    <div class="panel-body">
     <form:form action="processForm" cssClass="form-horizontal"
      method="post" modelAttribute="customer" onsubmit="return validationFun()">
      
      <div>
<h3>
<%
if (session.getAttribute("msgclc") != null ){
	out.println(session.getAttribute("msgclc"));
session.invalidate();
}
%>
</h3>
</div> 

      <!-- need to associate this data with customer id -->
      <form:hidden path="id" />
      
     <%--    <div>
       
<h3>
<%
if (session.getAttribute("msgclc") != null ){
	out.println(session.getAttribute("msgclc"));
session.invalidate();
}
%>
</h3>
</div>  --%>

      
      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">First
        Name</label>
       <div class="col-md-9">
        <form:input path="firstname" id="firstname" cssClass="form-control" />
        <span id="pfirstname"></span>
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">Last
        Name</label>
       <div class="col-md-9">
        <form:input path="lastname" id="lastname" cssClass="form-control" />
        <span id="plastname"></span>
       </div>
      </div>

      <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input path="email" id="myemail" cssClass="form-control" />
        <span id="pemail"></span>
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
         <form:button cssClass="btn btn-primary">Submit</form:button> 
       <%--   <button class="btn btn-dark fbtn1">List</button></a>
         <form:form action="list" cssClass="form-horizontal"
      method="get" modelAttribute="customer"> </form:form>  --%>
        <!-- <a href="list"><button class="btn btn-dark fbtn1"> submit</button></a>  -->
       <!--  <a href="list"><button class="btn btn-dark fbtn1"> List</button></a> -->
       </div>
      </div>

     </form:form>
     
   
      <form:form action="list" cssClass="form-horizontal"
      method="get" modelAttribute="customer">
      <%--  <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
       <form:button cssClass="btn btn-primary">List</form:button> 
       </div>
       </div> --%>
       
    </form:form>
     
     
   <%--   <form:form>
     
     
        <div>
        
<h3>
<%
if (session.getAttribute("msgclc") != null ){
	out.println(session.getAttribute("msgclc"));
session.invalidate();
}
%>
</h3>
</div> 
     </form:form> --%>
      
     
    </div>
    
    
   </div>
  </div>
 </div> 
 
 <script type="text/javascript">
  
 function validationFun(){
	 
	 var name= document.getElementById('firstname').value;
	 if(name==null||name==""){
		 
		 document.getElementById('pfirstname').innerHTML="**Please Enter first name";
		 
		 return false;
	 }
	
	 
	 var name=document.getElementById('lastname').value;
	 if(name==null||name==""){
		 
		 document.getElementById('plastname').innerHTML="**Please Enter last name";
		 return false;
	 }
	 
	
	 
	var email= document.getElementById('myemail').value;
	if(email.indexOf('@')<=0){
		
		
		document.getElementById('pemail').innerHTML="**invalid @ position";
	return false;
	}
	else{
		
		document.getElementById('pemail').innerHTML="";
	}
	
	if(email.charAt(email.length-4)!='.'){
		
		document.getElementById('pemail').innerHTML="**invalid . position";
		return false;
		
	}
	
	else{
		
		document.getElementById('pemail').innerHTML="";
	}
	
	 
 }
 
 
 </script>
 
</body>
</html>
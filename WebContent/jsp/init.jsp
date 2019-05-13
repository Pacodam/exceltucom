<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controller.Manager"%>
<%@page import="model.SheetA"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exceltucom</title>
</head>
<body>



<!--  obtener nombre del excel -->



<!-- parte del navegador superior -->


<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
  
  
  <%
      if (request.getAttribute("sheets") != null) {
           List<SheetA> sheets = (List<SheetA>) request.getAttribute("sheets"); 
           if(!sheets.isEmpty()){
               for(SheetA s: sheets){
         
   %>
          <li class="nav-item">
            <a class="nav-link" href="<%= s.getHref() %>"><%= s.getName() %></a> 
          </li>
    <% } 
        }
          } %>
   </ul>
   </nav>
    
    <% if(request.getAttribute("sheet") != null){
    	String sheet = (String) request.getAttribute("sheet");%>
    <!--  titulo del sheet -->
    <h1><%= sheet %></h1>
    <p>Excel evaluativo</p>
    <% } %>

	<!-- tabla con los datos del primer sheet -->
	
	<%  if(request.getAttribute("data") != null){
	     List<String[]> data = (List<String[]>) request.getAttribute("data"); %>
	
	<table class="table table-striped table-bordered ">
	   <thead>
	     <tr>
	      <% String[] firstRow = data.get(0);
	         for(int i = 0; i < firstRow.length; i++){
	       %>
	      <th scope="col"><% out.println(firstRow[i]); %></th>
	      <% } %>
	     </tr>
	  </thead>
	  <tbody>
	    <% for(int i = 1; i < data.size(); i++){ %>
	    <tr>
	    	<% String[] row = data.get(i);
	    	%>
	   
	      <% for(int j = 0; j < row.length; j++){ %>
	      <td><% out.println(row[j]); }%></td>
	   
	    </tr>
	     <% } %>
	    
	  
	    
	  </tbody>
   </table>
   <% } %>
</body>
</html>

































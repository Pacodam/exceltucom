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

<%
	Manager manager = new Manager();
%>

<!--  obtener nombre del excel -->



<!-- parte del navegador superior -->


<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
  
  <%
    	List<SheetA> sheets = manager.getSheets();
        for(SheetA s: sheets){
    %>
          <li class="nav-item">
            <a class="nav-link" href=<% out.println(s.getHref()); %>><% out.println(s.getName());%></a>
          </li>
          <% } %>
   </ul>
   </nav>
    
    <!--  titulo del sheet -->
    <h1><% out.println(manager.getSheetName(0)); %></h1>
    <p>Excel evaluativo</p>

	<!-- tabla con los datos del primer sheet -->
	
	<% List<String[]> data = manager.getSheet1(); %>
	
	<table class="table table-striped">
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
</body>
</html>

































<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="controller.Manager"%>
<%@page import="model.SheetA"%>
<%@page import="model.Alumno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Configuración</title>
</head>
<body>

<%
	Manager manager = new Manager();
%>

<!--  obtener nombre del excel -->



<!-- parte del navegador superior -->


<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
  <% List<SheetA> sheets = null; %>
  <%
  if (request.getAttribute("sheets") != null) {
      sheets = (List<SheetA>) request.getAttribute("sheets"); 
      if(!sheets.isEmpty()){
          for(SheetA s: sheets){
    
%>
     <li class="nav-item">
       <a class="nav-link" href="<%= s.getHref() %>"><%= "   "+   s.getName() + "   "   %></a> 
     </li>
<% } 
   }
     } %>
   </ul>
   </nav>
    
    <!--  titulo del sheet -->
    <h1><%= "Configuración" %></h1>
    <p>Configuración de parámetros</p>
    
    <form action="ExcelConfigs" method="post">
       
        
        Sheet to manage:<br>
              <% for(int i = 1; i < sheets.size(); i++){ 
                  if(i == 1){ %>
                      <input type="radio" name="selection" checked value="<%= i-1 %>"><%= sheets.get(i).getName() %><br>
              <% }    
                  else{ %>
                    <input type="radio" name="selection" value="<%= i-1 %>"><%= sheets.get(i).getName() %><br>
                  <%   }
                   }  %>
       <br>       
             
        <input type="submit" name="send" value="Manage">
          
             
              
    </form>
     <% if(request.getAttribute("cols") != null){
        HashMap<String, String> sheetCols = (HashMap<String, String>) request.getAttribute("cols");
        Set<Map.Entry<String, String>> set = sheetCols.entrySet();%>
        
      <% if(request.getAttribute("name") != null){
         String name = (String) request.getAttribute("name");  %>   
         
      Sheet <%= name %>
      
    <div class="form-group row">
      <div class="col-xs-3">
         <%   for (Map.Entry<String, String> me : set) {
                   System.out.print(me.getKey() + ": ");
                   System.out.println(me.getValue()); %>
             
        <label for="inputdefault"><%= me.getKey() %></label>
        <input class="form-control" id="inputdefault" type="text" value=<%=me.getValue() %> readonly>  
         <% } %>
      </div>
    </div>
   

    <% }} %>


</html>
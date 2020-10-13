<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

 <% if (session.getAttribute("tipoUser")=="docente"){ %>
	<%@include file="defaultHeader.jsp"%>
 	<%}else{ %>
 		<%@include file="headerEstVis.jsp"%>
    <%}%>	 
    
<div class="main">
</div>
<%@ include file="footer.jsp"%>
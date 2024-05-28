<%-- 
    Document   : connecte
    Created on : 20 nov. 2023, 10:49:00
    Author     : filia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connecte</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body class ="mt-4">
        
         <div class="d-flex justify-content-end">
            <a href="deconnexion" class="btn btn-dark btn-lg me-4" role="button" title="Deconnexion">Déconnexion</a>
         </div>
        
            <h1 class="mx-4">Bonjour ${user.nom}, </h1>
            
         <br>
        
        
         <button type="button" class="btn btn-primary btn-lg btn-block mx-4">Créer un groupe</button>
         
         <br><br>
         <hr>
         <br>
         <h2 class="mx-4 text-center"> Mes Groupes</h2>
         
         <div class="mx-5">
             <c:forEach items="${groupes}" var="groupe">
            <div>
               <h1>${groupe.idGroupe}</h1>
               <h1>${groupe.nomGroupe}</h1>
            </div>
            </c:forEach>
            
         </div>
         
     
         
         
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>

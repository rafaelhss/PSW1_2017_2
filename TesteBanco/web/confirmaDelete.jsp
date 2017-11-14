<%-- 
    Document   : confirmaDelete
    Created on : 14/11/2017, 19:54:13
    Author     : Rafael.Soares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tem certeza que quer deletar ${param.nome} ?</h1>
        <a href="Deletar?nome=${param.nome}">SIM!</a>
        <a href="" onclick="window.history.go(-1); return false;">Não!</a>
        <a href="Listar">Não!</a>
    </body>
</html>

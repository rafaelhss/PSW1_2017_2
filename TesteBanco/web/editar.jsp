<%-- 
    Document   : editar
    Created on : 14/11/2017, 20:07:43
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
        <form action="Editar">
            Nome: <input type="text" name="nome" value="${prod.nome}" readonly="readonly"> <br/>
            Preco: <input type="number" name="preco" value="${prod.preco}"> <br/>
            Validade: <input type="text" name="validade" value="${prod.validade}"> <br/>
            <input type="submit">
        </form>
    </body>
</html>

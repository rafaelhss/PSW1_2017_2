<%-- 
    Document   : lista
    Created on : 14/11/2017, 19:34:37
    Author     : Rafael.Soares
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de produtos:</h1>
        <table>
            <thead>
            <td>
                nome
            </td>
            <td>
                preco
            </td>
            <td>
                validade
            </td>
            <td>
                Editar
            </td>
            <td>
                deletar
            </td>
            </thead>
            <c:forEach items="${requestScope.lista}" var="prod">
                <tr>
                    <td>
                        ${prod.nome}
                    </td>
                    <td>
                        ${prod.preco}
                    </td>
                    <td>
                        ${prod.validade}
                    </td>                    
                    <td>
                        <a href="FormEditar?nome=${prod.nome}"> Editar</a>
                    </td>
                    <td>
                        <a href="confirmaDelete.jsp?nome=${prod.nome}"> Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
            
            
    </body>
</html>

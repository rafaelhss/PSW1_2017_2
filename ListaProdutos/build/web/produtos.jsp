<%-- 
    Document   : produtos.jsp
    Created on : 24/10/2017, 20:02:02
    Author     : Rafael.Soares
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {  
                color: #333;
                font-family: Helvetica, Arial, sans-serif;
                width: 640px; 
                border-collapse: 
                collapse; border-spacing: 0; 
            }

            td, th {  
                border: 1px solid transparent; /* No more visible border */
                height: 30px; 
                transition: all 0.3s;  /* Simple transition for hover effect */
            }

            th {  
                background: #DFDFDF;  /* Darken header a bit */
                font-weight: bold;
            }

            td {  
                background: #FAFAFA;
                text-align: center;
            }

            /* Cells in even rows (2,4,6...) are one color */        
            tr:nth-child(even) td { background: #F1F1F1; }   

            /* Cells in odd rows (1,3,5...) are another (excludes header cells)  */        
            tr:nth-child(odd) td { background: #FEFEFE; }  

            tr td:hover { background: #666; color: #FFF; }  
            /* Hover cell effect! */
            
            .promo{
                color: red;
            }
            
        </style>
    </head>
        
    <body>
        <h1>Lista de produtos</h1>
            <table>  
                <thead>  
                    <th>Produto</th>
                    <th>Preco</th>
                </thead>  
                <c:forEach items="${requestScope.prods}" var="p">
                    <c:if test="${p.promo == true}">
                       <tr class="promo"> 
                    </c:if>
                    <c:if test="${p.promo != true}">
                       <tr> 
                    </c:if>
                      
                        <td>${p.nome}</td>
                        <td>${p.preco}</td>
                    </tr>  
                </c:forEach>
            </table> 
    </body>
</html>

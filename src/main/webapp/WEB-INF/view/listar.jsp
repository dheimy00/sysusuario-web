<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar</title>
</head>
<body>
    <div align="center">
        <h1> Lista usuário</h1>
        <h3>
            <a href="novoUsuario">Novo Usuário</a>
        </h3>
        <table border="1">
        <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Idade</th>
            <th>Ação</th>
       </tr>
            <c:forEach var="usuario" items="${listaUsuario}">
                <tr>
 
                    <td>${usuario.nome}</td>
                    <td>${usuario.cpf}</td>
                    <td>${usuario.idade}</td>              
                    <td><a href="editar?id=${usuario.id}">Editar</a>
                             <a
                        href="excluir?id=${usuario.id}">Excluir</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
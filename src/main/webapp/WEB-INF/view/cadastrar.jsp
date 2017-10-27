<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar</title>
</head>
<body>
    <div align="center">
        <h1>Cadastrar </h1>
        <form:form action="salvar" method="post" modelAttribute="usuario">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Nome:</td>
                <td><form:input path="nome" /></td>
            </tr>
            <tr>
                <td>CPF:</td>
                <td><form:input path="cpf" /></td>
            </tr>
            <tr>
                <td>Idade:</td>
                <td><form:input path="idade" /></td>
            </tr>     
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Salvar"></td>
            </tr>                  
        </table>
        </form:form>
    </div>
</body>
</html>
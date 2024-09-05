<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Skaiciuotuvas</title>
        <jsp:include page="header.jsp"/>
        <style>
        .error{color:red}
        </style>
    </head>
    <body>
            <h2>Internetinis skaiciuotuvas.Galimos operacijos: sudeti, atimti, padauginti, dalinti</h2>
            <h3>Skaiciuotuvas jautrus neigiamiems skaiciams</h3>

        <form:form method="POST" action="skaiciuoti" modelAttribute= "number">
            Pirmas skaicius: <form:input type="number" path="sk1"/>
            <form:errors path="sk1" cssClass="error"/><p>
            Antras skaicius: <form:input type="number" path="sk2"/>
            <form:errors path="sk2" cssClass="error"/><p>
            Operacijos zenklas:
            <select name="zenklas">
                <option selected="selected" value="+">Sudetis</option>
                <option value="-">Atimtis</option>
                <option value="*">Daugyba</option>
                <option value="/">Dalyba</option>
            </select><p>
            <input type="submit" value="skaiciuoti">
        </form:form>
    </body>
</html>
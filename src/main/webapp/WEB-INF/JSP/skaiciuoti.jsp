<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Skaiciuoti</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <h4>  ${sk1} ${zenklas} ${sk2} = ${rezultatas} </h4>
        <form>
        <input type="button"  value ="Grizti atgal!" onclick="history.back()">
        </form>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix ="c" uri ="jakarta.tags.core" %>
<html>
<head>
        <title>Skaiciai</title>
        <jsp:include page="header.jsp"/>
</head>
<body class="container">
    <div class="table-responsive"> <!-- pritaiko vartotojui ekrana pagal jo telefona-->
    <table class="table table-striped">
        <tr>
            <th>Pirmas skaicius</th>
            <th>Zenklas</th>
            <th>Antras skaicius</th>
            <th>Rezultatas</th>
        </tr>

        <!--iteruoja per visa skaiciu sarasa-->
        <c:forEach var="element" itemps="${numbers}">

            <!--konstruoja iraso atnaujinimo adresa su skaiciaus id -->
                        <c:url var="atnaujinti" value="/update">
                        <c:param name="id" value="${element.id}"/>
            </c:url>

            <!--konstruoja iraso trynimo adresa su skaiciaus id -->
                        <c:url var="trinti" value="/delete">
                        <c:param name="id" value="${element.id}"/>
            </c:url>

             <!--konstruoja iraso perziuros adresa su skaiciaus id -->
                        <c:url var="rodyti" value="/show">
                        <c:param name="id" value="${element.id}"/>
                        </c:url>


            <tr>
                <td>${element.sk1}</td>
                <td>${element.zenklas}</td>
                <td>${element.sk2}</td>
                <td>${element.rezultatas}</td>
            <td>

            <!--atvaizduoti atnaujinimo adresa--> <a href="${atnaujinti}">Keisti</a>
            | <a href="${trinti}"
            onclick="if(!(confirm('Ar tikrai norite istrinti si irasa?'))) return false">Trinti</a
            | <!--atvaizduoti rodymo adresa--> <a href="${rodyti}">Rodyti</a>
            </td>

            </tr>

            </c:forEach>

            </table>
            </div>
    </body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Skaiciaus atnaujinimas</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
            <form:form name="number" action="/updateNumber" method="post">
            <!-- id butina pateikti formoje, kitaip i back-enda nueis null. Todel darome hidden, kad neredaguotu-->
            <input type="hidden"   name="id"  value="${number.id}"><p>
            Pirmas skaicius:<br>
            <input type="number"   name="sk1"  value="${number.sk1}"><p>
            Zenklas:<br>
            <input type="text"   name="zenklas"  value="${number.zenklas}"><p>
            Antras skaicius:<br>
            <input type="number"   name="sk2"  value="${number.sk2}"><p>
            Rezultatas:<br>
            <input type="number"   name="rezultatas"  value="${number.rezultatas}"><p>
            <input type="submit"   value="Atnaujinti">
        </form:form>
    </body>
</html>
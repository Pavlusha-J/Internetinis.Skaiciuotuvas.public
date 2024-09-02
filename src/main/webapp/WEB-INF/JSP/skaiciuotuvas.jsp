<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Skaiciuotuvas</title>
    </head>
    <body>
        <h2>Internetinis skaiciuotuvas.Galimos operacijos: sudeti, atimti, padauginti, dalinti</h2>
        <form method="POST" action="skaiciuoti">
            Pirmas skaicius: <input type="number" name="sk1"><p>
            Antras skaicius: <input type="number" name="sk2"><p>
            Operacijos zenklas:
            <select name="zenklas">
                <option selected="selected" value="+">Sudetis</option>
                <option value="-">Atimtis</option>
                <option value="*">Daugyba</option>
                <option value="/">Dalyba</option>
            </select><p>
            <input type="submit" value="skaiciuoti">
        </form>
    </body>
</html>
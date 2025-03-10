<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Proyecto</title>
</head>
<body>
    <h1>Registrar Nuevo Proyecto</h1>
    <form action="nuevoProyecto" method="post">
        Nombre: <input type="text" name="nombreProyecto" required><br><br>
        Descripción: <textarea name="descripcion"></textarea><br><br>
        Fecha Inicio: <input type="date" name="fechaInicio" required><br><br>
        Fecha Fin: <input type="date" name="fechaFin" required><br><br>
        Estado:
        <select name="estado">
            <option value="en curso">En curso</option>
            <option value="completado">Completado</option>
        </select><br><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>

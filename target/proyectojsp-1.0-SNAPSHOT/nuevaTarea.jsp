<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Tarea</title>
</head>
<body>
    <h1>Registrar Nueva Tarea</h1>
    <form action="nuevaTarea" method="post">
        <!-- ID del proyecto al que pertenece la tarea -->
        <input type="hidden" name="idProyecto" value="${idProyecto}">
        Descripción: <textarea name="descripcionTarea"></textarea><br><br>
        Responsable: <input type="text" name="responsable"><br><br>
        Fecha Inicio: <input type="date" name="fechaInicio"><br><br>
        Fecha Fin: <input type="date" name="fechaFin"><br><br>
        Estado:
        <select name="estado">
            <option value="pendiente">Pendiente</option>
            <option value="en progreso">En Progreso</option>
            <option value="completada">Completada</option>
        </select><br><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>

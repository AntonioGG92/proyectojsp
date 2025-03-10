<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Tareas</title>
</head>
<body>
    <h1>Tareas del Proyecto: ${proyecto.nombreProyecto}</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Descripción</th>
            <th>Responsable</th>
            <th>Fecha Inicio</th>
            <th>Fecha Fin</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="tarea" items="${tareas}">
            <tr>
                <td>${tarea.id}</td>
                <td>${tarea.descripcionTarea}</td>
                <td>${tarea.responsable}</td>
                <td>${tarea.fechaInicio}</td>
                <td>${tarea.fechaFin}</td>
                <td>${tarea.estado}</td>
                <td>
                    <!-- Botón para eliminar tarea (solo admin) -->
                    <c:if test="${sessionScope.admin == true}">
                        <a href="eliminarTarea?idTarea=${tarea.id}&idProyecto=${proyecto.id}"
                           onclick="return confirm('¿Eliminar esta tarea?')">
                           Eliminar
                        </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="nuevaTarea?idProyecto=${proyecto.id}">Agregar Nueva Tarea</a><br>
    <a href="listaProyectos">Volver a Lista de Proyectos</a>
</body>
</html>

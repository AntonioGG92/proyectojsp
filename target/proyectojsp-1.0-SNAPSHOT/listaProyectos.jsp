<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Proyectos</title>
</head>
<body>
    <h1>Proyectos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Fecha Inicio</th>
            <th>Fecha Fin</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="proyecto" items="${proyectos}">
            <tr>
                <td>${proyecto.id}</td>
                <td>${proyecto.nombreProyecto}</td>
                <td>${proyecto.descripcion}</td>
                <td>${proyecto.fechaInicio}</td>
                <td>${proyecto.fechaFin}</td>
                <td>${proyecto.estado}</td>
                <td>
                    <a href="listaTareas?idProyecto=${proyecto.id}">Ver Tareas</a> |

                    <!-- Botón para cambiar estado (solo admin) -->
                    <c:if test="${sessionScope.admin == true}">
                        <form action="cambiarEstadoProyecto" method="post" style="display:inline;">
                            <input type="hidden" name="idProyecto" value="${proyecto.id}">
                            <input type="hidden" name="nuevoEstado" value="${proyecto.estado == 'en curso' ? 'finalizado' : 'en curso'}">
                            <input type="submit" value="Cambiar Estado">
                        </form> |

                        <!-- Botón para eliminar proyecto (solo admin) -->
                        <a href="eliminarProyecto?id=${proyecto.id}" 
                           onclick="return confirm('¿Estás seguro de eliminar este proyecto?')">
                           Eliminar
                        </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="nuevoProyecto">Registrar Nuevo Proyecto</a>
</body>
</html>

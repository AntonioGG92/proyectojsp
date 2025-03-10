package servlets;

import dao.ProyectoDAO;
import modelo.Proyecto;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ActualizarEstadoProyectoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Boolean esAdmin = (Boolean) request.getSession().getAttribute("admin");
        if (esAdmin == null || !esAdmin) {
            response.sendRedirect("listaProyectos");
            return;
        }

        String idProyectoStr = request.getParameter("idProyecto");
        String nuevoEstado = request.getParameter("nuevoEstado");

        if (idProyectoStr != null && nuevoEstado != null) {
            int idProyecto = Integer.parseInt(idProyectoStr);
            ProyectoDAO proyectoDAO = new ProyectoDAO();
            Proyecto proyecto = proyectoDAO.obtenerProyecto(idProyecto);

            if (proyecto != null) {
                proyecto.setEstado(nuevoEstado);
                proyectoDAO.actualizarProyecto(proyecto);
            }
        }

        response.sendRedirect("listaProyectos");
    }
}

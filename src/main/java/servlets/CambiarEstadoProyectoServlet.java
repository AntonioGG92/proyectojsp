package servlets;

import dao.ProyectoDAO;
import modelo.Proyecto;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CambiarEstadoProyectoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Verificar si el usuario es admin
        Boolean esAdmin = (Boolean) request.getSession().getAttribute("admin");
        if (esAdmin == null || !esAdmin) {
            response.sendRedirect("listaProyectos");
            return;
        }

        String idStr = request.getParameter("id");
        String nuevoEstado = request.getParameter("estado");

        if (idStr != null && nuevoEstado != null) {
            int id = Integer.parseInt(idStr);
            ProyectoDAO proyectoDAO = new ProyectoDAO();
            Proyecto proyecto = proyectoDAO.obtenerProyecto(id);
            
            if (proyecto != null) {
                proyecto.setEstado(nuevoEstado);
                proyectoDAO.actualizarProyecto(proyecto);
            }
        }

        response.sendRedirect("listaProyectos");
    }
}

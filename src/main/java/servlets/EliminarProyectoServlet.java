package servlets;

import dao.ProyectoDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EliminarProyectoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Boolean esAdmin = (Boolean) request.getSession().getAttribute("admin");
        if (esAdmin == null || !esAdmin) {
            response.sendRedirect("listaProyectos");
            return;
        }

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            ProyectoDAO proyectoDAO = new ProyectoDAO();
            proyectoDAO.eliminarProyecto(id);
        }
        response.sendRedirect("listaProyectos");
    }
}

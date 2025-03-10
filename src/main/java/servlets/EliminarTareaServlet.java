package servlets;

import dao.TareaDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EliminarTareaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Boolean esAdmin = (Boolean) request.getSession().getAttribute("admin");
        if (esAdmin == null || !esAdmin) {
            response.sendRedirect("listaProyectos");
            return;
        }

        String idTareaStr = request.getParameter("idTarea");
        String idProyectoStr = request.getParameter("idProyecto");
        if (idTareaStr != null && idProyectoStr != null) {
            int idTarea = Integer.parseInt(idTareaStr);
            int idProyecto = Integer.parseInt(idProyectoStr);

            TareaDAO tareaDAO = new TareaDAO();
            tareaDAO.eliminarTarea(idTarea);

            response.sendRedirect("listaTareas?idProyecto=" + idProyecto);
        } else {
            response.sendRedirect("listaProyectos");
        }
    }
}

package servlets;

import dao.TareaDAO;
import dao.ProyectoDAO;
import modelo.Proyecto;
import modelo.Tarea;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListarTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("admin", true); // Modo admin activo

        String idProyectoStr = request.getParameter("idProyecto");
        if (idProyectoStr != null) {
            int idProyecto = Integer.parseInt(idProyectoStr);

            // DAO para obtener la lista de tareas
            TareaDAO tareaDAO = new TareaDAO();
            List<Tarea> tareas = tareaDAO.listarTareasPorProyecto(idProyecto);

            // DAO para obtener información del proyecto
            ProyectoDAO proyectoDAO = new ProyectoDAO();
            Proyecto proyecto = proyectoDAO.obtenerProyecto(idProyecto);

            // Pasar datos a la JSP
            request.setAttribute("proyecto", proyecto);
            request.setAttribute("tareas", tareas);

            // Redirigir a la vista (listaTareas.jsp)
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaTareas.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("listaProyectos");
        }
    }
}

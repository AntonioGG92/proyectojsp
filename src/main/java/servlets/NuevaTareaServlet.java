package servlets;

import dao.TareaDAO;
import dao.ProyectoDAO;
import modelo.Proyecto;
import modelo.Tarea;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class NuevaTareaServlet extends HttpServlet {

    // Muestra el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProyectoStr = request.getParameter("idProyecto");
        request.setAttribute("idProyecto", idProyectoStr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevaTarea.jsp");
        dispatcher.forward(request, response);
    }

    // Procesa el formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            ProyectoDAO proyectoDAO = new ProyectoDAO();
            Proyecto proyecto = proyectoDAO.obtenerProyecto(idProyecto);

            Tarea tarea = new Tarea();
            tarea.setDescripcionTarea(request.getParameter("descripcionTarea"));
            tarea.setResponsable(request.getParameter("responsable"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tarea.setFechaInicio(sdf.parse(request.getParameter("fechaInicio")));
            tarea.setFechaFin(sdf.parse(request.getParameter("fechaFin")));
            tarea.setEstado(request.getParameter("estado"));
            tarea.setProyecto(proyecto);

            TareaDAO tareaDAO = new TareaDAO();
            tareaDAO.guardarTarea(tarea);

            // Redirige a la lista de tareas del proyecto
            response.sendRedirect("listaTareas?idProyecto=" + idProyecto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

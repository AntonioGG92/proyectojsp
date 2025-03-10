package servlets;

import dao.ProyectoDAO;
import modelo.Proyecto;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class NuevoProyectoServlet extends HttpServlet {

    // Muestra el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevoProyecto.jsp");
        dispatcher.forward(request, response);
    }

    // Procesa el formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Proyecto proyecto = new Proyecto();
            proyecto.setNombreProyecto(request.getParameter("nombreProyecto"));
            proyecto.setDescripcion(request.getParameter("descripcion"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            proyecto.setFechaInicio(sdf.parse(request.getParameter("fechaInicio")));
            proyecto.setFechaFin(sdf.parse(request.getParameter("fechaFin")));
            proyecto.setEstado(request.getParameter("estado"));

            ProyectoDAO proyectoDAO = new ProyectoDAO();
            proyectoDAO.guardarProyecto(proyecto);

            // Redirige a la lista de proyectos
            response.sendRedirect("listaProyectos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

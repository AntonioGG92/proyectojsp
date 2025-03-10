package servlets;

import dao.ProyectoDAO;
import modelo.Proyecto;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListaProyectosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configurar el modo admin (Esto es solo para pruebas)
        request.getSession().setAttribute("admin", true); 

        String estado = request.getParameter("estado"); // Filtro opcional
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        List<Proyecto> proyectos = proyectoDAO.listarProyectos(estado);
        request.setAttribute("proyectos", proyectos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaProyectos.jsp");
        dispatcher.forward(request, response);
    }
}

package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class MascotaServlet
 */
@WebServlet("/MascotaServlet")
public class MascotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaServlet() {
        super();

    }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter lector = response.getWriter();
	    // 1. Obtener parámetros del formulario
	    String nombre = request.getParameter("nombre");
	    String tipo = request.getParameter("tipo");
	    String genero = request.getParameter("genero");
	    String raza = request.getParameter("raza");
	    String codigo = request.getParameter("codigo");
	    String sql = "insert into tblmascota(nombre, tipo, genero, raza, codigo) values (?, ?, ?, ?, ?)";
	    try {
		    Conexion conector = new Conexion();
			PreparedStatement pst = conector.conectarBD().prepareStatement(sql);
			pst.setString(1, nombre);
			pst.setString(2, tipo);
			pst.setString(3, genero);
			pst.setString(4, raza);
			pst.setString(5, codigo);
			int filas = pst.executeUpdate();
			if (filas > 0) {
				response.sendRedirect("/hols/mascotas.jsp");
			} else {
				response.getWriter().println("Problema al agregar la mascota");
			}
		} catch (Exception e) {
			lector.print("Posible error: "+e.getMessage());
		}
	}
}

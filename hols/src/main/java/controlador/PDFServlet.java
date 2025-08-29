package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Servlet implementation class PDF
 */
@WebServlet("/PDFServlet")
public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	        	Conexion conector = new Conexion();
	        	Document document = new Document();
	            PdfWriter.getInstance(document, response.getOutputStream()); // 1. Ruta del archivo de salida
	            document.open();
	    	    String sql = "SELECT nombre, tipo, genero, raza, codigo FROM tblmascota";
	            Statement stmt = conector.conectarBD().createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            document.add(new Paragraph("Lista de mascotas."));//parrafo basado en un titulo
	            while (rs.next()) {
	            	//Crear una tabla
		            PdfPTable table = new PdfPTable(2); // 2 columnas
		            table.addCell(rs.getString("nombre"));
		            table.addCell(rs.getString("tipo"));
		            table.addCell(rs.getString("genero"));
		            table.addCell(rs.getString("raza"));
		            table.addCell(rs.getString("codigo"));
		            document.add(table);
				}
	            document.close();
	          //Cerrar documento, resultset, statement y conexion al final el procedimiento de la informacion asignada al pdf
			} catch (Exception e) {
				throw new ServletException(e);
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
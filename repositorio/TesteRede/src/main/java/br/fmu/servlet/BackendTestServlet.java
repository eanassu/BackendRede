package br.fmu.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackendTestServlet
 */
@WebServlet("/test")
public class BackendTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackendTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Conexão iniciada. Endereço remoto: " + req.getRemoteAddr() + "; Host remoto: " +
                req.getRemoteHost() + "; Remote User: " + req.getRemoteUser() + "; Session: " + req.getSession());

        resp.setContentType("text/plain;charset=UTF-8");
        String var = req.getParameter("word");
        System.out.println("Param: " + var);

        OutputStream out = resp.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();
        dos.writeUTF("Server received: " + var +" resp: "+ texto);
        dos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

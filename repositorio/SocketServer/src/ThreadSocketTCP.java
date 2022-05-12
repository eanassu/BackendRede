import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadSocketTCP extends Thread{

	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in = null;
    private DataOutputStream out = null;
    private String mensagem = "";

	public ThreadSocketTCP(ServerSocket skt){
		serverSocket = skt;
	}


	public void run(){
		System.out.println("TCP Socket Server: Waiting for connections.");

        while (true) {
            try {

            	socket = serverSocket.accept();

                AtenderCliente atenderCliente = new AtenderCliente();
                atenderCliente.start();

            } catch (IOException ex) {
                System.out.println("***Error to accept connection. Error: " + ex.getMessage() + ".");
            }
        }

	}

	public class AtenderCliente extends Thread {

        public void run() {
        	try {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());

                mensagem = in.readUTF();

                System.out.println("TCP Socket Received: " + mensagem + ". From: " + socket.getInetAddress().getHostName()
                        + ":" + socket.getPort() + ":" + socket.getInetAddress().getAddress());
                String texto;
                Scanner scan = new Scanner(System.in);
                System.out.println("digite a resposta: ");
                texto = scan.nextLine();
                out.writeUTF(texto);
                out.flush();

                in.close();
                out.close();
                mensagem = "";

        	} catch (IOException ex) {
                System.out.println("Error creating the streams. Error: " + ex.getMessage());
            }

        }
    }
}

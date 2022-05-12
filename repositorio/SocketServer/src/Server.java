import java.net.DatagramSocket;
import java.net.ServerSocket;

public class Server {

	private static int porta_tcp = 9009;
	private ServerSocket serverSocketTCP;
	private static int porta_udp = 9008;
	private DatagramSocket serverSocketUDP;

	public Server(){

		//iniciando o servidor de Socket.
		try{
			System.out.println("Starting server on port TCP Socket: " + porta_tcp + ".");

			serverSocketTCP = new ServerSocket(porta_tcp);

			ThreadSocketTCP clienteSocket = new ThreadSocketTCP(serverSocketTCP);
			clienteSocket.start();

			System.out.println("Socket Server listening on TCP port: " + porta_tcp + ".");
		} catch (Exception e){
			System.out.println("Error starting the TCP server socket. Error: " + e.getMessage());
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}

package ServidorPassword;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorLanzaHilos {

	public static void main(String[] args) throws IOException {
		
		System.err.println("SERVIDOR >> Arrancando servidor, a la espera de conexiones...");
		ServerSocket socketEscucha = null;
		try {
		socketEscucha = new ServerSocket(1234);
		}catch(IOException e) {
			System.err.println("SERVIDOR >> Error!");
			e.printStackTrace();	
			return;
		}
		
		while(true) {
			Socket conexion  = socketEscucha.accept();
			System.err.println("SERVIDOR >> conexion establecida, lanzando hilos...");
			ServidorHilo sh = new ServidorHilo(conexion);
			Thread hilo = new Thread(sh);
			hilo.start(); 
		}
	}
}
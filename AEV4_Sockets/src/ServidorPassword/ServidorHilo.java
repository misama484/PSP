package ServidorPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import ServidorPassword.Password;

public class ServidorHilo implements Runnable{
	//declaramos los readers y writers y el socket
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;
	
	//CONSTRUCTOR
	public ServidorHilo(Socket conexion) {
		this.socket = conexion;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	}
	//Metodo para encriptar la password
	public static String encriptaPassword(String password) {
		
		char[] caracterpass = password.toCharArray();
		for (int i=0; i<caracterpass.length; i++){
			int valorascii = caracterpass[i];
			caracterpass[i] = (char) (valorascii + 1);
			
		}
		String passEncrypt = String.valueOf(caracterpass);
		return passEncrypt;
	}

	@Override
	public void run() {
		
		try {		
		//secuencia de envio del objeto
		ObjectOutputStream objetoEnviado = new ObjectOutputStream(socket.getOutputStream());
		Password p = new Password(null, null);
		objetoEnviado.writeObject(p);
		System.err.println("SERVIDOR >> Envio a cliente: " + p.getPass() + " - " + p.getPassEncrypt());
		
		//secuencia de recepcion del objeto
		ObjectInputStream objetoRecibido = new ObjectInputStream(socket.getInputStream());
		Password pMod = (Password) objetoRecibido.readObject();
		System.err.println("SERVIDOR >> Recibiendo de cliente " + pMod.getPass() + " - " + pMod.getPassEncrypt());
		//modificamos el objeto anyadiendo la password encriptada
		pMod.setPassEncrypt(encriptaPassword(pMod.getPass()));
		
		//envio del objeto completado
		objetoEnviado.writeObject(pMod);
		System.err.println("SERVIDOR >> Envio a cliente: " + pMod.getPass() + " - " + pMod.getPassEncrypt());
		
		
		//cerramos conexiones
		objetoEnviado.close();
		objetoRecibido.close();
		socket.close();
		//servidor.close();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

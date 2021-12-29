package ServidorPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner teclado = new Scanner(System.in);
		String nombreCliente = "Cliente";
		//System.out.println("Introduzca la contrasenya");
		//String Password = teclado.nextLine();
		
		//conexion
		System.out.println(nombreCliente + " >>> Arranca Cliente");
		System.out.println(nombreCliente + " >>> Conexion al servidor");
		Socket cliente = new Socket("localhost", 1234);
		
		//recepcion del objeto
		ObjectInputStream objetoRecibido = new ObjectInputStream(cliente.getInputStream());
		Password passVacio = (Password) objetoRecibido.readObject();
		
		//preparacion del objeto a enviar
		System.out.println(nombreCliente + " >> Actualizar datos del objeto ");
		System.out.println(nombreCliente + " >> Introducir password: ");
		String password = teclado.nextLine();
		passVacio.setPass(password);
		System.out.println(nombreCliente + " >> Enviando al servidor:  " + passVacio.getPass());
		
		
		//enviando el objeto
		ObjectOutputStream objetoEnviado = new ObjectOutputStream(cliente.getOutputStream());
		objetoEnviado.writeObject(passVacio);
		
		//recepcion del objeto con pass encriptada
		Password passEncriptado = (Password) objetoRecibido.readObject();
		System.out.println(nombreCliente + " >> Recibido de servidor: " + passEncriptado.getPass() + " - " + passEncriptado.getPassEncrypt());
		//cerramos conexiones
		objetoRecibido.close();
		objetoEnviado.close();
		cliente.close();
		
	}

}

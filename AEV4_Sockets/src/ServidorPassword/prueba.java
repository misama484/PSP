package ServidorPassword;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class prueba {


	public static void main(String[] args) {
		
		String pass = "casa";
		
		String[] passArray = pass.split("");
		
		for (int i=0; i<passArray.length; i++){
			System.out.println(passArray[i]);
			 
		}
		char[] caracterpass = pass.toCharArray();
		for (int i=0; i<caracterpass.length; i++){
			int valorascii = caracterpass[i];
			caracterpass[i] = (char) (valorascii + 1);
			System.out.println(caracterpass[i]);
			 
		}
		
	}

}

/*public void run() {
	//int numeroPuerto = 1234;
	try {
	ServerSocket servidor = new ServerSocket(numeroPuerto);
	System.err.println("SERVIDOR >> Escuchando...");
	Socket cliente = servidor.accept();
	
	//secuencia de envio del objeto
	ObjectOutputStream objetoEnviado = new ObjectOutputStream(cliente.getOutputStream());
	Password p = new Password("Pass", "PassEncrypt");
	objetoEnviado.writeObject(p);
	System.err.println("SERVIDOR >> Envio a cliente: " + p.getPass() + " - " + p.getPassEncrypt());
	
	//secuencia de recepcion del objeto
	ObjectInputStream objetoRecibido = new ObjectInputStream(cliente.getInputStream());
	Password pMod = (Password) objetoRecibido.readObject();
	System.err.println("SERVIDOR >> Recibiendo de cliente " + pMod.getPass() + " - " + pMod.getPassEncrypt());
	//modificamos el objeto anyadiendo la password encriptada
	pMod.setPassEncrypt(encriptaPassword(pMod.getPass()));
	
	//envio del objeto completado
	objetoEnviado.writeObject(pMod);
	System.err.println("SERVIDOR >> Envio a cliente: " + p.getPass() + " - " + p.getPassEncrypt());
	
	
	//cerramos conexiones
	objetoEnviado.close();
	objetoRecibido.close();
	cliente.close();
	servidor.close();
	}catch(IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/

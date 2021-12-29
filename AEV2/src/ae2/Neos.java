package ae2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Neos {
	public static void main(String[] args) {
		//definimos variable con el nombre del fichero a leer
		String nombreFichero = "NEOs.txt";
		
		//definimos lista donde se almacenaran las lineas del fichero
		//ArrayList<String> neos = new ArrayList<>();	
		
		//definimos objeto File al que le pasamos el nombre del fichero
		File ficheroNeos = new File(nombreFichero);
		
		//Definimos FileReader
		FileReader fr;
		String neoName = null;
		Double neoPos = null;
		Double neoVel = null;
		String[] neo = null;
;
		
		try {
			//Creamos objeto filereader
			fr = new FileReader(ficheroNeos);
			//creamos el buffer y le pasamos el filereader
			BufferedReader br = new BufferedReader(fr);
			//Definimos varible que almacenara la linea leida del fichero
			String linea = br.readLine();
			
			
			
			//Mientras la linea leida este con texto
			   while(linea != null)
	           {
				   neo = linea.split(",");
				   //for(int i = 0; i <= neo.length; i++) {
				   //Agregamos el contenido de neo a la lista
	              neoName = neo[0];
	              neoPos = Double.parseDouble(neo[1]);
	              neoVel = Double.parseDouble(neo[2]);
	              
	               //y seguimos leyendo
				   linea = br.readLine();	 
				   //}
	           }			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(neoName + "-" + neoPos + "-" + neoVel);
		//neos.forEach(System.out::println);
		
		//CREAR ARCHIVO PARA CADA NEO
		
		String ficheroProb = neoName + ".txt";
		File fichero = new File(ficheroProb);
		FileWriter fw;
		BufferedWriter bw;
		System.out.println("iniciando escritura en fichero...");
		
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			//escribe la variable en el fichero
			bw.write(String.valueOf(neoPos));
			//salta de linea
			bw.newLine();
			//escribe siguente variable
			bw.write(String.valueOf(neoVel));
			
			bw.close();
			fw.close();
			System.out.println("Fichero escrito con exito");
		} catch(IOException e) {
			e.printStackTrace();
		}
	
		
		//CREAR LISTA CON LOS DATOS DE PROBABILIDAD
		
		ArrayList<String> probabilidad = new ArrayList<>();
		
		

		
		//CALCULAR PROBABILIDADES NEOS
		
		//metodo para calcular
		//crear bucle para que haga esto en cada elemento del array.
		
		for(int x = 0; x < neo.length; x++) {
		double posicionNEO = Double.parseDouble(neo[1]);
		double velocidadNEO = Double.parseDouble(neo[2]);
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		System.out.println(resultado);
		//probabilidad.add(Integer.toString((int) resultado));
		
		}
		//probabilidad.add(String.valueOf(resultado));
		probabilidad.forEach(System.out::println);
		
		
		
		
		//CREAR ARCHIVO
		
		/*
		 * String ficheroProb = "ProbabilidadesNEOs.txt"; File fichero = new
		 * File(ficheroProb); FileWriter fw; BufferedWriter bw;
		 * System.out.println("iniciando escritura en fichero...");
		 * 
		 * try { fw = new FileWriter(fichero); bw = new BufferedWriter(fw); //recorremos
		 * la lista con las probabilidades for(int i = 0; i < probabilidad.size(); i++)
		 * { //pasamos el valor a una variable Double double res =
		 * Double.valueOf(probabilidad.get(0)); //redondeamos a dos decimales double
		 * valor = Math.round(res*100.0)/100.0; //escribimos en el archivo, pasandolo a
		 * string de nuevo bw.write(String.valueOf(valor)); } bw.close(); fw.close();
		 * System.out.println("Fichero escrito con exito"); } catch(IOException e) {
		 * e.printStackTrace(); }
		 */
		
		
		//MOSTRAR PROBABILIDADES NEO
		
		
		
	}
}
		

/*public static void creaProceso(String nombreFichero) {
	
	File fichero = new File(nombreFichero);	
	String neo[];
	
	try {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		ProcessBuilder builder;
		Process process;
		while(br.readLine() != null) {
						
			String clase = "AE2.Probabilidad";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			ArrayList <String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			neo = br.readLine().split(",");
			command.add(neo[0]);
			command.add(neo[1]);
			command.add(neo[2]);
			System.out.println(command);
			
			builder = new ProcessBuilder(command);
			process = builder.inheritIO().start();
		}
		
		
		
	
		
	} catch(IOException e) {
		e.printStackTrace();
	}
*/



 
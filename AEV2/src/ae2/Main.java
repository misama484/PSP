package ae2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//Leer informacion del archivo
		
		String fichero = "NEOs.txt";
		creaProceso(fichero);
		
		
		
	}
	
	public static void creaProceso(String nombreFichero) {
		
		File fichero = new File(nombreFichero);	
		String neo[];
		
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			ProcessBuilder builder;
			Process process;
			while(br.readLine() != null) {
							
				String clase = "ae2.Probabilidad";
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
	}
}


	


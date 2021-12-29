package ae21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//VISTO EL PROBLEMA DE LEER EL FICHERO, QUE SOLO LEE 6 LINEAS ALTERNANDO 1 SI Y 1 NO, MODIFICAMOS EL ARCHIVO NEO PARA QUE ALMACENE MENOS LINEAS
//NO CREO CLASE DE MOMENTO, TO-DO EN EL MAIN CON METODOS, YA QUE PETA AL LLAMAR A LA CLASE.
public class Main1 {

	public static void main(String[] args) {
		String fichero = "NEOs2.txt";
		creaProceso(fichero);
		
	}

		public static void creaProceso(String nombreFichero) {
				
		File fichero = new File(nombreFichero);	
		String neo[] = null;
		ArrayList<String> probabilidadesNeo = new ArrayList<>();
				
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.readLine() != null) {
				
				neo = br.readLine().split(",");
				//probabilidadesNeo.add(probabilidad(neo[0]));
				
				
			}
			
			for(int i=0; i<neo.length; i++) {
				System.out.println(neo[i]);
			}
					
					
					
				
					
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
		public static String[] probabilidad(String[] neo) {
			
			//CREAR LISTA CON LOS DATOS DE PROBABILIDAD
			
					String [] probabilidad = null;
					
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
					
					probabilidad[0] = neo[0];
					probabilidad[1] = String.valueOf(resultado);
					
					
					}
					
					//probabilidad.forEach(System.out::println);
					
					return probabilidad;

		}
		

}



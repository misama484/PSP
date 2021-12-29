package ae2;

import java.util.ArrayList;

public class Probabilidad {

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
				//probabilidad.add(String.valueOf(resultado));
				//probabilidad.forEach(System.out::println);
				
				return probabilidad;

	}

}

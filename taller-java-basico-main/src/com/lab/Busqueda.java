package com.lab;

import sun.rmi.server.InactiveGroupException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Busqueda {

	static Integer[] arreglo = { 2, 5, 9, 58, 36, 78, 84 };

	static Integer clave = 78;

	//Busqueda Secuencial
	public int secuencial() {
		int resultado = -1;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] == clave) {
				resultado = i;
				break;
			}
		}
		return resultado;
	}

	//Busqueda Binaria
	public int binaria() {

		int resultado = -1;
		int n = arreglo.length;
		int bajo = 0;
		int alto = n-1;
		while (bajo <= alto){
			int central = (bajo + alto)/2;
			if(arreglo[central] < clave){
			 	 bajo = central + 1;
			}else if(clave < arreglo[central]){
				alto = central -1;
			}else if(clave == arreglo[central]){
				return  central;
			}
		}
		return resultado;
	}

	public static void main(String[] args) {
		Busqueda busqueda = new Busqueda();
		
		int posicion = busqueda.binaria();

		//Validamos con el metodo siguiente para comprobar que el valor arrojado por Binaria sea el correcto
		int value = Arrays.asList(arreglo).lastIndexOf(clave);
		System.out.println(value);
		
		if(posicion == -1) {
			System.out.println("Valor no encontrado");
		}else {
			System.out.println("El valor clave " + clave + " encontrado en posicion " + posicion );
		}

	}
}

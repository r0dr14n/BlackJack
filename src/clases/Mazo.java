package clases;

import java.util.ArrayList;
import java.util.Collections;

import clases.Carta;
import clases.Carta.Palo;
import excepciones.NoHayMasCartasException;

public class Mazo {
	
	protected ArrayList <Carta> cartas;
	
	/*Constructor sin parámetros. Genera un mazo de cartas con todas las 
	cartas. Para ello, deberemos recorrer todos los Palos y todo los 
	posibles números y generaremos todas las cartas y las añadiremos a 
	la lista. Para recorrer los palos puedes utilizar:
	for (Palo p: Palo.values())*/
	
	public Mazo() {
		this.cartas = new ArrayList<Carta>();
		for (Palo p: Palo.values()) {
			for(int i=1 ; i<=13 ; i++) {
				Carta c = new Carta(i,p);
				this.cartas.add(c);
			}
		}
	}
	
	
	/*Método barajar() sin parametros. Se encargara de barajar el mazo 
	de cartas. Lo único que hace es utilizar el metodo shuffle de la clase 
	Collections:
	Collections.shuffle(cartas);*/
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	
	/*Sobreescribe el metodo toString para mostrar todo el mazo de 
	cartas recorriendo la lista*/
	
	public String toString() {
		for (Palo p: Palo.values()) {
			for (int i=1 ; i<=13 ; i++) {
				System.out.println(cartas);
			}
		}
		return "";
	}
	
	
	/*solicitarCarta. Metodo sin parametros que devuelve la primera carta 
	del mazo eliminandola de la lista*/
	
	public Carta solicitarCarta() throws NoHayMasCartasException {
		if (this.cartas.size()==0) {
			throw new NoHayMasCartasException();
		}
		Carta carta=cartas.get(0);
		this.cartas.remove(0);
		return carta;
	}
	
	
}
package clases;

import java.util.ArrayList;

import clases.Carta;
import clases.Carta.Palo;
import excepciones.NoHayMasCartasException;

public class Mano extends Mazo {
	
	
	/*• Constructor de la clase. Define una lista de cartas vacía, no invoca 
	al método de la superclase*/
	
	public Mano() {
		cartas = new ArrayList<Carta>();
	}
	
	
	/*• Método valorMano sin parámetros. Calcula cual es valor que 
	tenemos en la mano de cartas. Para hacerlo recorreremos la lista de 
	cartas sumando los puntos de cada una.*/
	
		public int valorMano() {
			int valor=0;
			for (Carta c : cartas) {
				valor = valor + c.getValor();
			}
			return valor;
		}
	    
	
	/*• Método finDeJuego que devuelve un boolean, indicando true si la 
	mano tiene más de 21 puntos, significando que el jugador se ha 
	pasado.*/
	
		public boolean finDeJuego() {
			if (valorMano()>21) {
				return true;
			}
		return false;
		}
	
	
	/*• Sobreescribe el método toString para que invoque al método de la 
	superclase, pero antes muestre la puntuación de la mano*/
	
		public String toString() {
			String resultado="Valor de la mano:"+valorMano();
			resultado=resultado+"\n"+super.toString();
			return resultado;
		}
	
	
	/*• Método pedirCarta(Mazo m) al que se le pasa un mazo de cartas, 
	deberá solicitar una carta al mazo e incluirla en la mano.*/
	
		public void pedirCarta(Mazo m) throws NoHayMasCartasException {
			Carta c = m.solicitarCarta();
			this.cartas.add(c);
		}
		
		
		
		
		
}

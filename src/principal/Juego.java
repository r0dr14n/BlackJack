package principal;

import java.util.Scanner;

import clases.Carta;
import clases.Mazo;
import clases.Mano;

public class Juego {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
	/*Implementa el método main para crear el juego. Deberá crear un mazo de 
	cartas y barajarlo. 
	A continuación creará un mazo de carta para el jugador y le preguntará si 
	quiere una carta. Si la quiere, se le solicitará un carta al mazo y acto 
	seguido se mostrará la mano.
	Si ha llegado al fin del juego (se ha pasado de 21) se sale diciendo que ha
	perdido, si no le pedirá al usuario si quiere otra carta. Si la quiere se pedirá 
	otra y se repetirá el proceso.
	Si no la quiere se saldrá del juego indicando la puntuación con la que se ha 
	plantado*/
		
		
		Mazo m = new Mazo();
		Mano ma = new Mano();
		boolean recoger=false;
		String robar;
		boolean finjuego=false;
		
		
		while (finjuego==false) {
		System.out.println("Barajando cartas...");
		m.barajar();
		System.out.println("¿Quieres una carta? (si/no)");
		System.out.println(ma);
		robar = teclado.nextLine();
		
		if (robar.equalsIgnoreCase("si")) {
			ma.pedirCarta(m);
		}
		else {
			break;
		}
		
//		System.out.println(ma.valorMano());
		
		finjuego = ma.finDeJuego();
		
		}
		
		System.out.println("Juego terminado");
		System.out.println("Valor final: "+ma.valorMano());
		
		
	}
}
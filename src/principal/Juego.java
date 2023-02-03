package principal;

import java.util.Scanner;

import clases.Carta;
import clases.Mazo;
import excepciones.NoHayMasCartasException;
import clases.Mano;

public class Juego {

	private static Mano jugador;
	private static Mazo baraja;
	private static Mazo baraja2;
	private static Mano jugador2;
	private static Mano banca;

	public static void main(String[] args) throws NoHayMasCartasException {
		
		Scanner teclado = new Scanner(System.in);
		
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
		
		inicializaJuego();
		juegaJugador();
		juegaBanca();
		resultado();
		
	}
	
	public static void inicializaJuego() {
		baraja = new Mazo();
		jugador = new Mano();
		banca = new Mano();
	}
	
	public static void juegaBanca() throws NoHayMasCartasException {
		// Debe saber la puntuacion del jugador e intentar superarla sin pasarse.
		do {
			banca.pedirCarta(baraja);
		} while (!banca.finDeJuego() && banca.valorMano()<jugador.valorMano());
		System.out.println("La banca ha sacado: "+banca);
	}
	
	public static void juegaJugador() throws NoHayMasCartasException {
		Scanner teclado = new Scanner (System.in);
		String robar = "";
		boolean finjuego = false;
		boolean finjuegoo = false;
				
		while (finjuego==false && finjuegoo==false) {
		System.out.println("Barajando...");
		baraja.barajar();
		System.out.println("¿Quieres una carta? (s/n)");
		System.out.println(jugador.toString());
		robar = teclado.nextLine();
		
			if (robar.equalsIgnoreCase("s")) {
				jugador.pedirCarta(baraja);
			}
			else {
				finjuego=true;
			}
		finjuegoo = jugador.finDeJuego();
		}
		
	}
	
	public static void resultado() {
		System.out.println("Juego terminado\n");
		
		if (jugador.valorMano()>21 && banca.valorMano()>21) {
			System.out.println("Ambos habéis perdido:\nTú y la banca os habeis pasado de 21\n");
		}
		else if (banca.valorMano()>21) {
			System.out.println("La banca ha perdido:\nSe ha pasado de 21\n");
		}
		else if (jugador.valorMano()>21) {
			System.out.println("Has perdido\nTe has pasado de 21");
		}
		else {
			if (jugador.valorMano()>banca.valorMano() && 
					jugador.valorMano()<=21 && banca.valorMano()<=21) {
				System.out.println("Ganaste a la banca\n");
			}
			else if (jugador.valorMano()==banca.valorMano()
					&& jugador.valorMano()<=21 && banca.valorMano()<=21) {
				System.out.println("Empate\n");
			}
			else if (jugador.valorMano()<banca.valorMano() && 
					jugador.valorMano()<=21 && banca.valorMano()<=21) {
				System.out.println("Perdiste contra la banca\n");
			}
		}
		
		System.out.println("Tú valor final: "+jugador.valorMano()+"\n");
		System.out.println("Valor final del rival: "+banca.valorMano()+"\n");
	}
	
}
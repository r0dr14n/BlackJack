package clases;

public class Carta {
	
	enum Palo {
		TREBOL, DIAMANTES, CORAZONES, PICAS
		};
		
	private int num_palo;
	private Palo palo;
	
	// Constructor
	
	public Carta() {
		this.num_palo=0;
	}
	
	// Constructor con parametros
	
	public Carta(int num_palo, Palo palo){
		if (num_palo>=1 && num_palo<=13) {
		this.num_palo=num_palo;
		this.palo=palo;
		}
	}
	
	// Getters
	
	public int getNum_palo() {
		return num_palo;
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	/*Método getValor que devuelve el valor que tiene cada carta en el 
	BlackJack. Los valores serán: 11 para el AS (1), 10 para las figuras 
	(J,Q,K o 11, 12 y 13) y el valor correspondiente para el resto de las 
	cartas (2, 3, 4, 5, 6, 7, 8, 9)*/
	
	public int getValor() {
			if (this.num_palo>1 && this.num_palo<=10) {
				return this.num_palo;
			} else if (this.num_palo==1) {
				return 11;
			} else {
				return 10;
			}
	}
	
	/*Método mostrarNumero sin parámetros que devuelve un String con 
	la representación de cada número. Para el 1 habrá que mostrar 
	“AS”, para la 11 habrá que mostrar “J”, para la 12 habrá que 
	mostrar “Q”, para la 13 “K” y para el resto su correspondiente valor.*/
	
	public String mostrarNumero() {
		if (this.num_palo==1) {
			return "AS";
		} else if (this.num_palo==11) {
			return "J";
		} else if (this.num_palo==12) {
			return "Q";
		} else if (this.num_palo==13) {
			return "K";
		} else {
			return Integer.toString(this.num_palo);
		}
	}
	
	/*Sobreescribe el método toString para que muestre la carta de la 
	siguiente manera [numero – Palo]. Por ejemplo, [3 – CORAZONES]*/
	
	public String toString () {
		return num_palo+" - "+palo;
	}
	
	
	
	
	
	
}

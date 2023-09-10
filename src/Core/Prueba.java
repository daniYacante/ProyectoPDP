package Core;
import Core.Clases.Cartas.Carta;
import Core.Clases.Cartas.CartaEncantamientoIneficiente;
import Core.Clases.Cartas.CartaMasoquista;
import Core.Clases.Cartas.cartaUltimaEsperanza;
import Core.Clases.Heroes.*;
import Core.Clases.Jefes.Jefe1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        lucha();
    }
    public static void lucha() {
		//hice unos cambios en paladin (extiende de heroe y no de humano, vamos a ver si es lo mismo).
		Heroe Juan = new Paladin("Yo");
        Jefe1 Malo = new Jefe1("Malo");
		//Es medio raro, es como que hago dos conexiones entre los dos. CREO que es lo mejor, o podria ser con una conexion nada mas?
		Carta cartaDeJuan = new cartaUltimaEsperanza(Juan);
		Juan.setCartaElegida(cartaDeJuan);
        System.out.println(Juan.getClase());
        System.out.println(Juan.getHabilidad1());
        System.out.println("Estado del enemigo");
		System.out.println(Malo.getVida());
		System.out.println(String.format("El heroe va a atacar al enemigo con %s",Juan.getHabilidad1().getNombre()));
		Juan.usarH1(Malo);
		System.out.println("Estado del enemigo");
		System.out.println(Malo.getVida());
        System.out.println("Estado del Heroe");
		System.out.println(Juan.getVida());
		System.out.println(String.format("El enemigo va a atacar al heroe con %s",Malo.getHabilidad1().getNombre()));
		Malo.usarH1(Juan);
		System.out.println("////////");
		System.out.println("Estado del Heroe");
		System.out.println(Juan.getVida());
		System.out.println(Juan.getVidaMaxima());
		System.out.println("///////");
		Juan.getCartaElegida().realizarEfecto();
		System.out.println(Juan.getVida());
		//PRUEBAS DE MENSAJE
		Juan.getCartaElegida().realizarEfecto();
		Malo.usarH1(Juan);
		System.out.println("Estado del Heroe");
		System.out.println(Juan.getVida());
		Juan.getCartaElegida().realizarEfecto();
		System.out.println("///////");
		System.out.println(Malo.getVida());
		System.out.println(String.format("El heroe va a atacar al enemigo con %s",Juan.getHabilidad1().getNombre()));
		Juan.usarH1(Malo);
		System.out.println("Estado del enemigo");
		System.out.println(Malo.getVida());
        System.out.println("///////");
		Malo.usarH1(Juan);
		Juan.getCartaElegida().realizarEfecto();

		System.out.println("\n\n\n\n\n");
		System.out.println("--------ENCONTRAR CARTAS--------");
		//Algoritmo para encontrar Cartas

		Scanner sc = new Scanner(System.in);
		int respuesta = 0;
		boolean investigar = false;
		System.out.println("¿Quieres investigar la sala? [1] Si [2] No");
		do {
			try{
				respuesta = sc.nextInt();
				investigar = true;
			} catch(InputMismatchException e){
				System.out.println("Caracter no valido, intentelo de vuelta");
				sc.nextLine();
			}
			sc.nextLine();
		} while (investigar == false);

		if (respuesta == 1) {
			System.out.println("Investigando...");
			//Podriamos hacer que las chances de encontrar una carta sean 3/10
			//3 numeros "al azar" del 0 al 9
			Random rnd = new Random();
			int numero1 = rnd.nextInt(0, 10);
			int numero2;
			int numero3;

			//Evitar repeticiones
			do {
				numero2 = rnd.nextInt(0, 10);
			}while(numero2 == numero1);

			do {
				numero3 = rnd.nextInt(0, 10);
			}while(numero3 == numero1 || numero3 == numero2);

			int dadoSelector = rnd.nextInt(0, 10);
			System.out.println(String.format("Para verificar que los numeros que tocaron son: %s %s %s y el dado %s", numero1, numero2, numero3, dadoSelector));
			if ((dadoSelector == numero1) || (dadoSelector == numero2) || (dadoSelector == numero3)){
				//Seleccionar una carta al azar para entregarsela
				//Creo una instancia Heroe para mostrar los datos
				Heroe HeroeMensajero = new Paladin("Arthas");
				int seleccionador = rnd.nextInt(0,10);

				//Null porque si no me tira error que puede estar no inicializado
				Carta cartaEncontrada = null;
				switch (seleccionador){
					case 0,5,4:
						cartaEncontrada = new cartaUltimaEsperanza(HeroeMensajero);
						break;
					case 1,6:
						cartaEncontrada = new CartaEncantamientoIneficiente(HeroeMensajero);
						break;
					case 2,7,9:
						cartaEncontrada = new CartaMasoquista(HeroeMensajero);
						break;
					case 3,8:
						cartaEncontrada = new cartaUltimaEsperanza(HeroeMensajero);
						break;

				}
				System.out.println("Has encontrado la:");
				System.out.println(cartaEncontrada.getNombreCarta());
				cartaEncontrada.imprimirDescripcion();

				System.out.println("¿A quien se la deseas dar?:\n");
				//Se mostraria la lista de Heroes Vivos, ESTA ES UNA DE PRUEBA
				ArrayList<Heroe> listaHeroesVivos = new ArrayList<Heroe>(5);
				Heroe prueba1 = new Mago("Prueba1");
				Heroe prueba2 = new Mago("Prueba2");
				Heroe prueba3 = new Clerigo("Prueba3");
				Heroe prueba4 = new Rogue("Prueba4");

				listaHeroesVivos.add(Juan);
				listaHeroesVivos.add(prueba4);
				listaHeroesVivos.add(prueba3);
				listaHeroesVivos.add(prueba2);
				listaHeroesVivos.add(prueba1);
 				System.out.println(String.format("[1]%s [2]%s [3]%s [4]%s [5]%s", listaHeroesVivos.get(0).getNombre(), listaHeroesVivos.get(1).getNombre(), listaHeroesVivos.get(2).getNombre(), listaHeroesVivos.get(3).getNombre(), listaHeroesVivos.get(4).getNombre()));
			    respuesta = sc.nextInt() - 1;
				//No encontre otra forma de hacerlo
				Heroe heroePortador = listaHeroesVivos.get(respuesta);
				Carta cartaPuesta = null;
				switch (seleccionador){
					case 0,5,4:
						cartaPuesta = new cartaUltimaEsperanza(heroePortador);
						break;
					case 1,6:
						cartaPuesta = new CartaEncantamientoIneficiente(heroePortador);
						break;
					case 2,7,9:
						cartaPuesta = new CartaMasoquista(heroePortador);
						break;
					case 3,8:
						cartaPuesta = new cartaUltimaEsperanza(heroePortador);
						break;

				}
				heroePortador.setCartaElegida(cartaPuesta);
				System.out.println(String.format("¡%s se hizo con la %s!", heroePortador.getNombre(), heroePortador.getCartaElegida().getNombreCarta()));
			} else {
				System.out.println("No se ha encontrado nada :(");
			}
		} else {
			System.out.println("Los jugadores entonces siguen avanzando...");
		}
	}
}


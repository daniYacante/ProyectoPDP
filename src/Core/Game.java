package Core;
import java.util.Scanner;
import Core.Clases.*;
public class Game {
	static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println(" _____       _       _                                ______           __                              \r\n"
				+ "/  __ \\     | |     | |                               | ___ \\         / _|                             \r\n"
				+ "| /  \\/ __ _| | __ _| |__   ___ _______  ___   _   _  | |_/ / __ ___ | |_ ___  ___  ___  _ __ ___  ___ \r\n"
				+ "| |    / _` | |/ _` | '_ \\ / _ \\_  / _ \\/ __| | | | | |  __/ '__/ _ \\|  _/ _ \\/ __|/ _ \\| '__/ _ \\/ __|\r\n"
				+ "| \\__/\\ (_| | | (_| | |_) | (_) / / (_) \\__ \\ | |_| | | |  | | | (_) | ||  __/\\__ \\ (_) | | |  __/\\__ \\\r\n"
				+ " \\____/\\__,_|_|\\__,_|_.__/ \\___/___\\___/|___/  \\__, | \\_|  |_|  \\___/|_| \\___||___/\\___/|_|  \\___||___/\r\n"
				+ "                                                __/ |                                                  \r\n"
				+ "                                               |___/                                                   ");
		pressToContinue();
		lucha();
	}

	public static int readConsole(String mensaje,int maxOpciones) {
		int input;
		do {
			System.out.println(mensaje);
			try {
				input=Integer.parseInt(scanner.next());
			} catch (Exception e) {
				input=-1;
				System.out.println("Opcion no valida");
			}
		} while (input<1 || input>maxOpciones);
		return input;
		
	}
	public static void pressToContinue() {
		System.out.println("Presione cualquier tecla plara continuar");
		scanner.nextLine();
		return;
	}
	public static void lucha() {
		Heroe humano1=new Heroe(1);
		Heroe enemigo1=new Heroe(1);
		System.out.println("Estado del enemigo");
		System.out.println(enemigo1.getVida());
		System.out.println(String.format("El heroe va a atacar al enemigo con %s",humano1.getClase().getHabilidad1().getNombre()));
		humano1.usarH1(enemigo1);
		System.out.println("Estado del enemigo");
		System.out.println(enemigo1.getVida());
		pressToContinue();
	}
}

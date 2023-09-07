package Core;
import java.util.ArrayList;
import java.util.Scanner;
import Core.Clases.*;
import Core.Clases.Heroes.Heroe;
//import java.util.concurrent.TimeUnit;
public class Game {
	static Scanner scanner =new Scanner(System.in);
	private static boolean Fin=false;
	private static int nSala=1;
	private static int status;
	private static int nHeroes=5;
	private static int respAccion;
	private static int respObjetivo;
	private static ArrayList<Heroe> listaHeroesVivos= new ArrayList<Heroe>(nHeroes);
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
		do {
			listaHeroesVivos.add(new Heroe("Yo",3));
			System.out.println("A luchaaaaar!!!!");
			status=lucha(crearSala(nSala));
			if ((status==-1) || (nSala==2)) {
				Fin=true;
			}else {
				nSala++;
			}
		} while (!Fin);
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
	public static int lucha(Sala sala) {
		String msg="";
		ArrayList<? extends Human> listaEnemigos= sala.getListaEnemigo();
		Human target = null;
		int contHeroes=0;
		Heroe heroe;
		do {
			heroe=listaHeroesVivos.get(contHeroes);
			if (!heroe.checkDead()) {
				msg=String.format("¿Que hara nuestro heroe %s?\n1-%s\n2-%s\n3-%s", heroe.getNombre(),heroe.getClase().getHabilidad1().getNombre(),heroe.getClase().getHabilidad2().getNombre(),heroe.getClase().getHabilidadEspecial().getNombre());
				respAccion=readConsole(msg, 3);
				respObjetivo=readConsole("¿A...\n1-Aliados?\n2-Enemigo?",2);
				if (respObjetivo==1) {
					for (Heroe aliado: listaHeroesVivos) {
						if (!heroe.getNombre().equals(aliado.getNombre())) {
							System.out.println(aliado.getNombre());
						}
					}
				}else {
					int cont=1;
					msg="Enemigos:\n";
					for (Human enemigo: listaEnemigos) {
						msg=msg.concat(String.format("%d-%s\n",cont ,enemigo.getNombre()));
						cont++;
					}
					respObjetivo=readConsole(msg, listaEnemigos.size());
					target=listaEnemigos.get(respObjetivo-1);
				}
				switch (respAccion) {
				case 1:
					System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getClase().getHabilidad1().getNombre(),target.getNombre()));
					heroe.usarH1(target);
					break;
				case 2:
					System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getClase().getHabilidad2().getNombre(),target.getNombre()));
					heroe.usarH2(target);
					break;
				case 3:
					System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getClase().getHabilidadEspecial().getNombre(),target.getNombre()));
					heroe.usarEsp(target);
					break;
				default:
					break;
				}
				if (target.checkDead()) {
					System.out.println(String.format("%s ha caido", target.getNombre()));
					listaEnemigos.remove(respObjetivo-1);
				}else {
					System.out.println(String.format("La vida de %s es: %d", target.getNombre(),target.getVida()));
				}
			}
		
		} while (listaHeroesVivos.size()!=0 || listaEnemigos.size()!=0);
		if (listaHeroesVivos.size()==0) {
			return -1;
		} else {
			return 1;
		}
	}
	public static Sala crearSala(int nSala) {
		Sala sala=new Sala(nSala);
		return sala;
	}
}

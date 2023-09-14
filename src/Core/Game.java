package Core;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Core.Clases.*;
import Core.Clases.Cartas.Carta;
import Core.Clases.Heroes.*;
//import java.util.concurrent.TimeUnit;
public class Game {
	public static Scanner scanner =new Scanner(System.in);
	private static boolean Fin=false;
	private static int nSala=1;
	private static int status;
	private static int nHeroes=5;
	private static int respAccion;
	private static int respObjetivo;
	private static String msg;
	private static ArrayList<Heroe> listaHeroesVivos= new ArrayList<Heroe>(nHeroes);
	public static Random intRandom=new Random();
	public static void main(String[] args) {
		System.out.println("\u001B[32m"+" _____       _       _                                ______           __                              \r\n"
				+ "/  __ \\     | |     | |                               | ___ \\         / _|                             \r\n"
				+ "| /  \\/ __ _| | __ _| |__   ___ _______  ___   _   _  | |_/ / __ ___ | |_ ___  ___  ___  _ __ ___  ___ \r\n"
				+ "| |    / _` | |/ _` | '_ \\ / _ \\_  / _ \\/ __| | | | | |  __/ '__/ _ \\|  _/ _ \\/ __|/ _ \\| '__/ _ \\/ __|\r\n"
				+ "| \\__/\\ (_| | | (_| | |_) | (_) / / (_) \\__ \\ | |_| | | |  | | | (_) | ||  __/\\__ \\ (_) | | |  __/\\__ \\\r\n"
				+ " \\____/\\__,_|_|\\__,_|_.__/ \\___/___\\___/|___/  \\__, | \\_|  |_|  \\___/|_| \\___||___/\\___/|_|  \\___||___/\r\n"
				+ "                                                __/ |                                                  \r\n"
				+ "                                               |___/                                                   "+"\u001B[0m");
        imprimir("Existe la profecia de unos estudiantes que lograrian completar la carrera en 5 años, los profesores creian que esto era un absurdo, que nadie asi llegaria algun dia...\nHASTA ESTE DIA... TU ERES UNO.");
        pressToContinue();
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("                                           Menu                                                           ");
        System.out.println("----------------------------------------------------------------------------------------------------------");
//Menu de opciones:
        int valor = 0;
        msg="Por favor, elija una opcion\n[1] JUGAR\n[2] COMO JUGAR\n[3] CREDITOS\n[4] SALIR\n";
        //imprimir(msg);
        valor=readConsoleInt(msg, 4);
        switch(valor){
            case 1:
                opcion1();
                break;
            case 2:
                opcion2();
                //Para que empiece el menu de vuelta luego de la opcion 2 y 3, podria ser con esto?:
                //respuesta = false;
                break;
            case 3: 
                opcion3();
                //respuesta = false;
                break;
            case 4: 
                System.out.println("¡Gracias por jugar!");
                break;
            default:
                System.out.println("El numero: "+ valor +" no es ninguna opcion, el juego se cerrara automaticamente.");
                break;
        }
        
	}

	
    public static void opcion1(){
    	//String respString;
    	int respInt;
    	Sala stage;
    	String nombre = readConsoleString("Jugador, ¿cual es tu nombre?");
        System.out.println("Muy bien,"+nombre+". Elige tus 5 personajes que iran en el equipo:");
        do {
	        msg="[1] Paladin\n[2] Mago\n[3] Sacerdote\n[4] Rogue";
	        int respuestaUsuario=readConsoleInt(msg,4);
	        Heroe seleccionHeroe=crearHeroe(respuestaUsuario);
	        
	        //Imprimir stats
	        
	        imprimir("Clase: "+ seleccionHeroe.getClase()+"\n"+"Vida: "+ seleccionHeroe.getVidaMaxima());
	        //System.out.println("Ataque: "+ seleccionHeroe.get());
	        
	        respuestaUsuario=readConsoleInt("¿Seleccionar?\n[1] Si \n[2] No",2);
	        if (respuestaUsuario==1) {
	        	seleccionHeroe.setNombre(readConsoleString(String.format("Ingrese nombre para el %s",seleccionHeroe.getClase())));
	        	listaHeroesVivos.add(seleccionHeroe);
	        }
        } while (listaHeroesVivos.size()<5);
        System.out.println("¡Los jugadores estan listos! comenzamos...");
        Carta item;
        //Lucha
        do {
        	stage=crearSala(nSala);
        	imprimir("Entras a una sala donde la luz escasea, sientes el olor a humedad en el aire, sobre una mesa ves"
        			+" algo que brilla y hacia tu derecha ves lo que parece ser una puerta.");
        	respInt=readConsoleInt("¿Que decides hacer?\n[1] Investigar que es lo que brilla \n[2] Ir hacia la \"puerta\"",2);
        	if (respInt==1) {
        		item=stage.investigar();
        		respInt=readConsoleInt("Deseas guardartelo?\n[1] Si \n[2] No", 2);
        		if (respInt==1) {
        			System.out.println("Quien deberia llevarlo?");
        			for (int i=0;i<listaHeroesVivos.size();i++) {
        				System.out.println(String.format("[%d] - %s",i+1,listaHeroesVivos.get(i).getNombre()));
        			}
        			respInt=readConsoleInt("",listaHeroesVivos.size());
					item.setPortador(listaHeroesVivos.get(respInt-1));
					listaHeroesVivos.get(respInt-1).setCartaElegida(item);
					System.out.println(String.format("%s ahora lleva %s", listaHeroesVivos.get(respInt-1).getNombre(),listaHeroesVivos.get(respInt-1).getCartaElegida().getNombreCarta()));
        		}else {
        			System.out.println("Lo dejas donde estaba...");
        		}
        		
        		System.out.println("Luego de ver que es lo que brillaba, te diriges hacia la puerta y...");
        	}
    		System.out.println("A luchaaaaar!!!!");
    		status=lucha(stage);
    		if ((status==-1) || (nSala==2)) {
        		Fin=true;
        	}else {
        		nSala++;
        	}
        	
        } while (!Fin);
        //End Lucha
    }
    
    public static void opcion2(){
        //Mejorar el texto de explicacion, esto nada mas se hizo para ver como luce.
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Este es un manual de como jugar Calabozos y Profesores.");
        System.out.println("Como has podido ver en el menu para acceder aca, es un videojuego con el que interactua con el usuario a traves de preguntas y respuestas tomadas por teclado");
        System.out.println("Calabozos y Profesores es un videojuego de solo un jugador o multijugador (hasta 4 maximo)");
        System.out.println("Te adentraras a un mundo donde los profesores haran de tu vida una desgracia para que no te recibas en 5 a�os");
        System.out.println("Pero yo confio en ti jugador, �Suerte!");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Presione alguna tecla para volver al menu.");
        pressToContinue();
    }
    
    public static void opcion3(){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Hecho por: ");
        System.out.println("");
        System.out.println("?Mauro Sorbello?");
        System.out.println("");
        System.out.println("?Daniel Yacante?");
        System.out.println("");
        System.out.println("?Joaquin Villegas?");
        System.out.println("");
        System.out.println("Para: Paradigmas");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Presione alguna tecla para volver al menu.");
        pressToContinue();
    }
	public static int lucha(Sala sala) {
		String msg="";
		ArrayList<? extends Human> listaEnemigos= sala.getListaEnemigo();
		Human target = null;
		int contHeroes;
		int contEnemigos;
		Heroe heroe;
		do {
			contHeroes=0;
			contEnemigos=0;	
			do {
				heroe=listaHeroesVivos.get(contHeroes);
				if (!heroe.checkDead()) {
					msg=String.format("¿Que hara nuestro heroe %s?\n[1]- Atacar \n[2]- Usar Objeto", heroe.getNombre());
					respAccion=readConsoleInt(msg, 2);
					if (respAccion==1){
						msg=String.format("¿Como quiere atacar?\n1-%s\n2-%s\n3-%s",heroe.getHabilidad1().getNombre(),heroe.getHabilidad2().getNombre(),heroe.getHabilidadEspecial().getNombre());
						respAccion=readConsoleInt(msg, 3);
						respObjetivo=readConsoleInt("¿A...\n1-\u001B[32mAliados?\u001B[0m\n2-\u001B[31mEnemigo\u001B[0m?",2);
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
							respObjetivo=readConsoleInt(msg, listaEnemigos.size());
							target=listaEnemigos.get(respObjetivo-1);
						}
						switch (respAccion) {
						case 1:
							System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidad1().getNombre(),target.getNombre()));
							heroe.usarH1(target);
							break;
						case 2:
							System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidad2().getNombre(),target.getNombre()));
							heroe.usarH2(target);
							break;
						case 3:
							System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidadEspecial().getNombre(),target.getNombre()));
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
					}else {
						if (heroe.getCartaElegida()!=null) {
							//System.out.println("Has usado el item, este tendra efecto en proximo turno");
							heroe.getCartaElegida().realizarEfecto();
						}else {
							System.out.println("No lleva nada para usar!!");
							//Forma de que no pierda el turno xD
							contHeroes--;
						}
					}
				}
				contHeroes++;
				}while(contHeroes<listaHeroesVivos.size());
				do {
					Human enemigo=listaEnemigos.get(contEnemigos);
					System.out.println(String.format("%s ataca!!", enemigo.getNombre()));
					target=listaHeroesVivos.get(intRandom.nextInt(listaHeroesVivos.size()-1));
					enemigo.usarH1(target);
					System.out.println(String.format("La vida de %s es: %d", target.getNombre(),target.getVida()));
					contEnemigos++;
				}while(contEnemigos<listaEnemigos.size());
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

    public static void cleanConsole(){
        System.out.println("\n\n\n\n\n");
    }
    
    public static int readConsoleInt(String mensaje,int maxOpciones) {
		int input;
		do {
			//System.out.println(mensaje);
			imprimir(mensaje);
			try {
				input=Integer.parseInt(scanner.next());
			} catch (Exception e) {
				input=-1;
				System.out.println("Opcion no valida");
			}
		} while (input<1 || input>maxOpciones);
		return input;
		
	}
    public static String readConsoleString(String mensaje) {
    	String input;
    	boolean leido=false;
    	//System.out.println(mensaje);
    	imprimir(mensaje);
    	do {
			try {
				input=scanner.next();
				leido=true;
			} catch (Exception e) {
				input="";
				System.out.println("Entrada no tomada");
			}
    	}while (!leido);
    	return input;
    }
	public static void pressToContinue() {
		System.out.println("Presione cualquier tecla para continuar");
		scanner.nextLine();
		return;
	}
	public static Heroe crearHeroe(int tipo){
		Heroe H;
		switch (tipo) {
		case 1:
			H=new Paladin();
			break;
		case 2:
			H=new Mago();
			break;
		case 3:
			H=new Clerigo();
			break;
		case 4:
			H=new Rogue();
			break;
		default:
			H=new Paladin();
			break;
		}
		return H;
	}
	public static void imprimir(String mensaje) {
		int maxHorizontal=100;
		//int maxVertical=10;
		String format = "|\t%-91s|";
		String[] mensj=mensaje.split("\n");
		int iMensj=0;
		ArrayList<String> pantalla= new ArrayList<String>();
		ArrayList<String> lineas = new ArrayList<String>();
		for(String cadenas:mensj) {
			lineas.add(cadenas);
		}
		String linea;
		String cadTemp;
		for (int j=0; j<lineas.size()+2;j++) {
			linea="";
			if(j==0 || j==lineas.size()+1) {
				for(int i=0;i<maxHorizontal;i++) {
					if (i==0 || i==maxHorizontal-1) {
						linea+="+";
					}else{
						linea+="~";
					}
				}
			}else {
				cadTemp=lineas.get(iMensj);
				if (cadTemp.length()<80) {
					linea=String.format(format,cadTemp );
					iMensj++;
				}else {
					//Hacer que divida la linea en multiples
					String lineaTemp="";
					for (String palabra:cadTemp.split(" ")) {
						if (linea.length()+palabra.length()<80) {
							linea+=palabra+" ";
						}else {
							lineaTemp+=palabra+" ";
						}
					}
					linea=String.format(format, linea);
					lineas.add(iMensj+1,lineaTemp);
					iMensj++;
					//System.out.println(lineaTemp.getClass());
				}
			}
			
			pantalla.add(linea);
		}
		for (String line:pantalla) {
			System.out.println(line);
		}
	}
}

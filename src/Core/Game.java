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
	        System.out.println("Existe la profecia de unos estudiantes que lograrian completar la carrera en 5 anios, los profesores creian que esto era un absurdo, que nadie asi llegaria algun dia... ");
                System.out.println("HASTA ESTE DIA... TU ERES UNO.");
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------------------------------------------");
		pressToContinue();
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println("                                           Menu                                                           ");
                System.out.println("----------------------------------------------------------------------------------------------------------");
                
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
                
                //Menu de opciones:
                boolean respuesta = false;
                int valor = 0;
                do{
                
                System.out.println("[1] JUGAR");
                System.out.println("[2] COMO JUGAR");
                System.out.println("[3] CREDITOS");
                System.out.println("[4] SALIR");
                System.out.println("Por favor, elija una opcion");
                
                try{
                    valor = sc.nextInt(); 
                    respuesta = true;
                
                    switch(valor){
                        case 1:
                            opcion1();
                            break;
                        case 2:
                            opcion2();
                            //Para que empiece el menu de vuelta luego de la opcion 2 y 3, podria ser con esto?:
                            respuesta = false;
                            break;
                        case 3: 
                            opcion3();
                            respuesta = false;
                            break;
                        case 4: 
                            System.out.println("�Gracias por jugar!");
                            break;
                        default:
                            System.out.println("El numero: "+ valor +" no es ninguna opcion, el juego se cerrara automaticamente.");
                            break;
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("¡Opcion no valida!, por favor intente de vuelta.");
                    respuesta = false;
                    sc.nextLine();
                }
                
                
                }while(respuesta == false);

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

    public static void cleanConsole(){
        System.out.println("\n\n\n\n\n");
    }
    
    
    public static void opcion1(){
       //A continuacion esto es una prueba de como podria ser la seleccion de heroe.
        ArrayList<HeroePrueba> seleccionHeroes = new ArrayList<>();

        Scanner sc =new Scanner(System.in);
        System.out.println("Selecciona la cantidad de jugadores:");
        System.out.println("  [1]  [2]  [3]  [4]  ");
        int i = sc.nextInt();
        sc.nextLine();
        for (int j = 1; j < i + 1; j++){
            System.out.println("Jugador "+j+", ¿cual es tu nombre?");
            //No me lee el nombre, �es este el problema de limpiar el buffer?
            
            String nombre = sc.nextLine();
            boolean seguirAvanzando = false;
            boolean seguirAvanzando2 = false;
            do{
                System.out.println("Muy bien,"+nombre+". Elige tu personaje:");
                System.out.println("[1] Paladin");
                System.out.println("[2] Mago");
                System.out.println("[3] Sacerdote");
                System.out.println("[4] Rogue");
                //Seleccion de personaje, aca le mostraremos las stats y darle la opcion de que si confirma ser el heroe seleccionado o buscar otro.
                //Que no se pase de vivo y que agregue un numero valido
                int respuestaUsuario = 0;
                boolean siguienteJugador;
                //estara bien asi?
                do{
                    siguienteJugador = true;
   

                    try {
                        respuestaUsuario = sc.nextInt() - 1;
                        if (respuestaUsuario < 0 || respuestaUsuario >= seleccionHeroes.size()){
                            System.out.println("Por favor, un numero de los que aparecen en pantalla. Intente de vuelta.");
                        }
                    }catch(java.util.InputMismatchException e){
                        siguienteJugador = false;
                        System.out.println("�Eso no es un numero!, intente de vuelta.");
                        sc.nextLine();
                    }

                }while((respuestaUsuario < 0 || respuestaUsuario  >= seleccionHeroes.size()) || siguienteJugador == false);

                
                HeroePrueba seleccionHeroe;
                seleccionHeroe = seleccionHeroes.get(respuestaUsuario);
                //Imprimir stats
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println("Clase: "+ seleccionHeroe.get_clase());
                System.out.println("Vida: "+ seleccionHeroe.get_vidaMaxima());
                System.out.println("Da�o: "+ seleccionHeroe.get_danioAtaque());
                System.out.println("----------------------------------------------------------------------------------------------------------");
            
                //Para establecer un numero donde no haya errores.
                respuestaUsuario = -1;
                //Otro Try/catch en caso de que no este poniendo algo adecuado.
                do {
                    System.out.println("�Seleccionar? [1] Si [2] No");
                    try{
                        respuestaUsuario = sc.nextInt();
                        if (respuestaUsuario == 1 || respuestaUsuario == 2){
                            seguirAvanzando = true;
                        }else{
                            System.out.println("No es un numero valido ese, intentelo de vuelta");
                        } 
                    }catch(java.util.InputMismatchException e){
                    
                        System.out.println("Esa no es ninguna opcion, por favor intente de vuelta");
                        //Si agrega mas parametros de lo normal
                        
          
                    }
                    sc.nextLine();
                    
                }while(seguirAvanzando == false);

                
                //por simpleza si el usuario ingresa 2 o alguna otra cosa, que se reinicie. Luego vemos el tema de excepciones
                if (respuestaUsuario == 1){
                    System.out.println("�Eres "+ nombre +", el "+ seleccionHeroe.get_clase() +"!");
                    //Otra cosa, aca se podria entonces ya crear lo que seria la lista de Aliados, los vamos agregando.
                    seguirAvanzando2 = true;
                } 
            }while(seguirAvanzando2 == false);

        }
        System.out.println("�Los jugadores estan listos! comenzamos...");
    }
    
    public static void opcion2(){
        Scanner sc =new Scanner(System.in);
        //Mejorar el texto de explicacion, esto nada mas se hizo para ver como luce.
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Este es un manual de como jugar Calabozos y Profesores.");
        System.out.println("Como has podido ver en el menu para acceder aca, es un videojuego con el que interactua con el usuario a traves de preguntas y respuestas tomadas por teclado");
        System.out.println("Calabozos y Profesores es un videojuego de solo un jugador o multijugador (hasta 4 maximo)");
        System.out.println("Te adentraras a un mundo donde los profesores haran de tu vida una desgracia para que no te recibas en 5 a�os");
        System.out.println("Pero yo confio en ti jugador, �Suerte!");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Presione alguna tecla para volver al menu.");
        sc.nextLine();
        
    }
    
    public static void opcion3(){
        Scanner sc =new Scanner(System.in);
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
        sc.nextLine();
    }
   

}

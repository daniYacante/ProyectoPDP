package Core.Clases;
import java.util.ArrayList;
import java.util.Random;
import Core.Game;

/**
 * La clase Human, una de las mas importantes, de aca heredan tanto heroes como jefes. Se crea aca atributos y metodos que tengan en comun
 */
public abstract class Human {
	/**
	 * el nombre del humano
	 */
    //Atributos
    protected String nombre="";
	/**
	 * un int que nos indica si utilizo la habilidad especial
	 */
    protected int useEsp = 0;
	/**
	 * el dado que lleva cada uno de las instancias creadas, que sirve para la lucha.
	 */
    Random dado = new Random();
    
    //ACLARACION: Hay valores que les di por tirar una idea, luego los modificamos si queremos.
    //Tres tipos de vida
    //1. vidaBase que represente la vida que toma desde un inicio
    //2. vidaMaxima la vida que el personaje tenga como maxima por subir de nivel, usar items (cartas), etc.
    //3. vidaActual la que va a representar el estado del personaje (si malherido, si esta muerto, si esta sano, etc.).
	/**
	 * la vida que el personaje tenga como maxima.
	 */
    protected int vidaMaxima;
	/**
	 * la que va a representar el estado del personaje (como esta en su estado actual, sano al 100%, malherido, etc.)
	 */
    protected int vidaActual;
	/**
	 * la armadura del humano, con la cual puede evitar daños de habilidades
	 */
    protected int armadura;
    //Supongo que pasaria lo mismo con el mana
	/**
	 * la cantidad de mana maxima que tiene el humano
	 */
    protected int manaMaximo;
	/**
	 * la cantidad de mana actual que lleva el humano (sirve para ver si puede usar tal habilidad o no)
	 */
    protected int manaActual;
    
    //Daño de Ataque
	/**
	 * buff al daño de las habilidades
	 */
    protected int modAtaquete = 0;
    
    //el nivel y la experiencia
    //Se podria desbloquear la habilidad especial a tal nivel, �o les permitimos el uso desde un inicio?
    //la barra de experiencia luego de completarse, automaticamente debe de volver a 0 (y sumarle lo que quedo restando).
    //realizar aumentos de la vida, del mana y la fuerza.
    //la experienciaRequerida se refiere a la cantidad que se necesita para subir al siguiente nivel.
    //Se podria realizar una funcion subirNivel() (que la llame en el momento que barraExperiencia >= experienciaRequerida) que pase como parametro el nivel actual, y adentro que haya un switch dependiendo del nivel. Se aumentan las stats ahi.
    //protected int nivel = 1;
    //protected int nivelMaximo = 10;
    //protected int barraExperiencia = 0;
    //protected int experienciaRequerida = 15;
    
    //�Esta muerto?
    //realizar una funcion que se deberia usar frecuentemente durante el combate (antes de cederle el turno al siguiente personaje) que revise la vidaActual de cada uno.
    // si vidaActual <= 0, de alguna forma "hacerlo invisible" para que no pueda realizar acciones. isDead darlo por true.
	/**
	 * booleano donde nos muestra si el humano esta muerto o no, true si lo esta, false si no.
	 */
    protected boolean isDead = false;
    
    //Aliados
    //Pensaba que estaria bueno un array que nos muestre los aliados (maximo como 10 por el tema de que son 10 heroes). 
    //No se bien si se inicializa asi, pero por el momento para que darnos la idea.
    //Asi en los combates, supongamos el caso de que algun heroe tiene la habilidad especial de potenciar/curar a algun aliado suyo.
    //Y asi si hubiera uno de aliados, �habria que hacer uno de enemigos?
	/**
	 *  ArrayList de los aliados que lo acompañan
	 */
    protected ArrayList<Human> aliados;
    
    //Objetos
    //Un almacenamiento de objetos (peque�o) para asi llevar la Carta, consumibles, etc.
    //protected ArrayList<> objetos = new String[3];
    //Tipo (Heroe, Enemigo(Jefe y esbirro))
	/**
	 * el tipo, si es un heroe, o un villano, o esbirro
	 */
    protected String tipo;
    //Clase
	/**
	 * la clase de heroe o del jefe, si es por ejemplo un paladin, o druida en caso de heroes, o si es Jefe1 o Jefe2 en caso de jefe
	 */
    protected String clase="";
	/**
	 * breve descripcion de la clase
	 */
    protected String descripcion="";
    //Habilidades
	/**
	 * la habilidad 1 del humano
	 */
    protected Habilidad habilidad1;
	/**
	 * la habilidad 2 del humano (Jefes y esbirros no la llevan)
	 */
	protected Habilidad habilidad2;
	/**
	 * la habilidad especial del Heroe o Jefe (los heroes tienen restricciones, mientras que los jefes para usarla no)
	 */
	protected Habilidad habilidadEspecial;

    //Metodos

	/**
	 * retornamos el tipo
	 * @return String de ya sea heroe, jefe, esbirro, etc
	 */
	public String getTipo(){
		return tipo;
	}

	/**
	 * da la breve descripcion de la clase elegida
	 * @return String breve descripcion
	 */
    public String getDescripcion(){
        return descripcion;
    }

	/**
	 * entrega el nombre del Human
	 * @return String el nombre
	 */
    public String getNombre() {
		return nombre;
	}

	/**
	 * Nos devuelve la vida actual del Human
	 * @return int numero de su vida actual
	 */
    public int getVida(){
        return this.vidaActual;
    }

	/**
	 * Nos devuelve el mana actual del human
	 * @return int numero de su mana actual
	 */
    protected int getMana(){
        return this.manaActual;
    }
//    protected int getNivel(){
//        return this.nivel;
//    }

	/**
	 * Se revisa si esta muerto o no
	 * @return boolean true si esta muerto, false si no
	 */
    public boolean checkDead(){
        return this.isDead;
    }

	/**
	 * Se le da el nombre al Human
	 * @param nombre nombre del Human
	 */
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo en el que muestra por pantalla cuantos puntos de vida pierde el objetivo al ser alcanzado por una habilidad, tambien nos puede mostrar si llega a morir
	 * @param dmg el daño que recibio
	 */
    public void recibirDmg(int dmg) {
    	System.out.println(String.format("%s ha recibido %s puntos de daño", this.getNombre(),dmg));
    	if ((this.vidaActual-dmg)<=0) {
    		this.vidaActual=0;
    		this.isDead=true;
    		System.out.println(String.format("%s ha muerto!!", this.nombre));
    	}else {
    		this.vidaActual-=dmg;
    	}
    };

	/**
	 * metodo en el que muestra por pantalla cuantos puntos de vida recibe el objetivo al ser curado por alguna habilidad, no se cura si ya esta al maximo.
	 * @param vida vida que recibe como cura
	 */
    protected void curarse(int vida) {
    	if ((this.vidaActual+vida)>this.vidaMaxima) {
    		this.vidaActual=this.vidaMaxima;
    		System.out.println(String.format("%s esta al maximo vida", this.nombre));
    	}else {
    		this.vidaActual+=vida; 		
    		System.out.println(String.format("%s ha recuperado %s puntos de vida", this.nombre,vida));
    	}
    }

	/**
	 * El metodo de la modificacion del daño de ataque
	 * @param mod que es el numero con el que se modifica
	 */
    protected void modificarAtaque(int mod) {
    	this.modAtaquete=mod;
    }

	/**
	 * Retorna la clase de la que es
	 * @return String de la clase a la que pertenece
	 */
    public String getClase() {
		return clase;
	}

	/**
	 * Nos da la habilidad 1 del Human
	 * @return Habilidad la habilidad 1
	 */
	public Habilidad getHabilidad1() {
		return habilidad1;
	}

	/**
	 * Nos da la habilidad 2 del Human
	 * @return Habilidad de la habilidad 2
	 */
	public Habilidad getHabilidad2() {
		return habilidad2;
	}

	/**
	 * Nos da la habilidad especial del Human
	 * @return Habilidad de la habilidad especial
	 */
	public Habilidad getHabilidadEspecial() {
		return habilidadEspecial;
	}

	/**
	 * el uso de la habilidad 1, aca es donde se muestra el uso del dado
	 * @param objetivo es el objetivo a quien vamos a accionar la habilidad
	 */
	public void usarH1(Human objetivo) {
        String usuario = this.getTipo();
        boolean usar=false;
        if (this.getHabilidad1().isTiraDado()) {
        	int d20=this.tirarDado();
        	if (d20<this.armadura) {
        		Game.imprimir(String.format("%s sabe como defenderse...\no el oponente es muy malo...\nno se ha asestado el golpe",objetivo.nombre));
        	}else {
        		usar=true;
        	}
        }else{
			//Hago este else debido a que para habilidades como modificacion de daño no se estan tomando en cuenta
			if (this.getHabilidad1().getEfectoManaLanzador() < this.manaActual){
				this.getHabilidad1().usar(objetivo, 0);
				this.manaActual -= this.getHabilidad1().getEfectoManaLanzador();
			}
		}
        if (usar) {
        	//Si es enemigo hace el ataque
	        if (usuario.equals("Enemigo")){
	            this.getHabilidad1().usar(objetivo, this.modAtaquete);
	        //Si es heroe verifica el mana
	        }else if (this.getHabilidad1().getEfectoManaLanzador()<this.manaActual) {
				this.getHabilidad1().usar(objetivo, this.modAtaquete);
				this.manaActual-=this.getHabilidad1().getEfectoManaLanzador();
			}
        }
	}

	/**
	 * el uso de la habilidad 2, aca es donde se muestra el uso del dado
	 * @see Human#tirarDado()
	 * @param objetivo es el objetivo a quien vamos a accionar la habilidad
	 */
    public void usarH2(Human objetivo) {
        String usuario = this.getTipo();
        boolean usar=false;
        if (this.getHabilidad2().isTiraDado()) {
        	int d20=this.tirarDado();
        	if (d20<this.armadura) {
        		Game.imprimir(String.format("%s sabe como defenderse...\no el oponente es muy malo...\nno se ha asestado el golpe",objetivo.nombre));
        	}else {
        		usar=true;
        	}
        } else {
			if (this.getHabilidad2().getEfectoManaLanzador() < this.manaActual){
				this.getHabilidad2().usar(objetivo, this.modAtaquete);
				this.manaActual -= this.getHabilidad2().getEfectoManaLanzador();
			}
		}
        if (usar) {
	        if (usuario.equals("Enemigo")){
	            this.getHabilidad2().usar(objetivo, this.modAtaquete);
	        }
			else if (this.getHabilidad2().getEfectoManaLanzador()<this.manaActual) {
	            this.getHabilidad2().usar(objetivo, this.modAtaquete);
	            this.manaActual-=this.getHabilidad2().getEfectoManaLanzador();
			}
        }
	}

	/**
	 * el uso de la habilidad especial, aca es donde se muestra el uso del dado
	 * @param objetivo es el objetivo a quien vamos a accionar la habilidad
	 */
	public void usarEsp(Human objetivo) {
        String usuario = this.getTipo();
        boolean usar=false;
        if (this.getHabilidad1().isTiraDado()) {
        	int d20=this.tirarDado();
        	if (d20<this.armadura) {
        		Game.imprimir(String.format("%s sabe como defenderse...\no el oponente es muy malo...\nno se ha asestado el golpe",objetivo.nombre));
        	}else {
        		usar=true;
        	}
        }
        if (usar) {
	        if (usuario.equals("Enemigo")){
	            this.getHabilidadEspecial().usar(objetivo, 0);
	        }
			else if (this.getHabilidadEspecial().getEfectoManaLanzador()<this.manaActual) {
				this.getHabilidadEspecial().usar(objetivo,this.modAtaquete);
				this.manaActual-=this.getHabilidadEspecial().getEfectoManaLanzador();
	            this.useEsp = 1;
			}
        }
	}

	public void changeUesEsp(){
		if (useEsp == 0) useEsp = 1;
		else useEsp = 0;
	}

	public int getuseEsp(){
		return useEsp;
	}

	/**
	 * El uso del dado, con el que veremos si evitamos el daño de la habilidad o tendremos que recibirlo
	 * @return int el valor que salio al tirar el dado
	 */
	public int tirarDado() {
		//nextInt va de 0 a 19, como los dados d20 van del 1-20, se le suma 1
		Game.imprimir("Necesitas tirar un d20");
		Game.pressToContinue();
		int valorDado=dado.nextInt(20)+1;
		Game.imprimir(String.format("Has sacado un %d", valorDado));
		return valorDado;
	}
    //Durante o antes de un combate, el jugador deberia tener la opcion de usar algun consumible de los objetos que lleva.
    //Revisara cuales objetos son consumibles y los muestra por pantalla.
    protected void usarObjeto(){
    
    }
    
    protected void subirNivel(){
    
    }
    
    protected void recuperarMana(){
    
    }

	/**
	 * para el uso de la Carta del Masoquista, se da una gran cantidad de mana al human
	 * @see Core.Clases.Cartas.CartaMasoquista
	 * @param cantMana la cantidad de mana que se setea luego de usar la carta
	 */
	public void setMana(int cantMana){
        this.manaActual += cantMana;
    }
    //Para una carta:
    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    //Para una carta:

	/**
	 * Para el uso de la Carta de la Ultima Esperanza, se cura el portador
	 * @param cantVida la cantidad de vida con la que se cura
	 */
    public void keyCurarse(int cantVida){
        curarse(cantVida);
    }

}
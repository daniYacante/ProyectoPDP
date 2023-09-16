package Core.Clases;
import java.util.ArrayList;
import java.util.Random;
import Core.Game;
public abstract class Human {
    //Atributos
    protected String nombre="";
    protected boolean useEsp = false;
    Random dado = new Random();
    
    //ACLARACION: Hay valores que les di por tirar una idea, luego los modificamos si queremos.
    //Tres tipos de vida
    //1. vidaBase que represente la vida que toma desde un inicio
    //2. vidaMaxima la vida que el personaje tenga como maxima por subir de nivel, usar items (cartas), etc.
    //3. vidaActual la que va a representar el estado del personaje (si malherido, si esta muerto, si esta sano, etc.).
    protected int vidaMaxima;
    protected int vidaActual;
    protected int armadura;
    //Supongo que pasaria lo mismo con el mana
    protected int manaMaximo;
    protected int manaActual;
    
    //Daño de Ataque
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
    protected boolean isDead = false;
    
    //Aliados
    //Pensaba que estaria bueno un array que nos muestre los aliados (maximo como 10 por el tema de que son 10 heroes). 
    //No se bien si se inicializa asi, pero por el momento para que darnos la idea.
    //Asi en los combates, supongamos el caso de que algun heroe tiene la habilidad especial de potenciar/curar a algun aliado suyo.
    //Y asi si hubiera uno de aliados, �habria que hacer uno de enemigos?
    protected ArrayList<Human> aliados;
    
    //Objetos
    //Un almacenamiento de objetos (peque�o) para asi llevar la Carta, consumibles, etc.
    //protected ArrayList<> objetos = new String[3];
    //Tipo (Heroe, Enemigo(Jefe y esbirro))
    protected String tipo;
    //Clase
    protected String clase="";
    protected String descripcion="";
    //Habilidades
    protected Habilidad habilidad1;
	protected Habilidad habilidad2;
	protected Habilidad habilidadEspecial;
    protected int turnoAnt = 0;

    //Metodos


	public String getTipo(){
		return tipo;
	}
    public String getDescripcion(){
        return descripcion;
    }
    public String getNombre() {
		return nombre;
	}
    public int getVida(){
        return this.vidaActual;
    }
    protected int getMana(){
        return this.manaActual;
    }
//    protected int getNivel(){
//        return this.nivel;
//    }
    public boolean checkDead(){
        return this.isDead;
    }
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    protected void recibirDmg(int dmg) {
    	System.out.println(String.format("%s ha recibido %s puntos de daño", this.getNombre(),dmg));
    	if ((this.vidaActual-dmg)<=0) {
    		this.vidaActual=0;
    		this.isDead=true;
    		System.out.println(String.format("%s ha muerto!!", this.nombre));
    	}else {
    		this.vidaActual-=dmg;
    	}
    };
    protected void curarse(int vida) {
    	if ((this.vidaActual+vida)>this.vidaMaxima) {
    		this.vidaActual=this.vidaMaxima;
    		System.out.println(String.format("%s esta al maximo vida", this.nombre));
    	}else {
    		this.vidaActual+=vida; 		
    		System.out.println(String.format("%s ha recuperado %s puntos de vida", this.nombre,vida));
    	}
    }
    protected void modificarAtaque(int mod) {
    	this.modAtaquete=mod;
    }
    public String getClase() {
		return clase;
	}
	public Habilidad getHabilidad1() {
		return habilidad1;
	}
	public Habilidad getHabilidad2() {
		return habilidad2;
	}
	public Habilidad getHabilidadEspecial() {
		return habilidadEspecial;
	}
    
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
        }
        if (usar) {
        	//Si es enemigo hace el ataque
	        if (usuario.equals("Enemigo")){
	            this.getHabilidad1().usar(objetivo, 0);
	        //Si es heroe verifica el mana
	        }else if (this.getHabilidad1().getEfectoManaLanzador()<this.manaActual) {
				this.getHabilidad1().usar(objetivo, 0);
				this.manaActual-=this.getHabilidad1().getEfectoManaLanzador();
			}
        }
	}
    public void usarH2(Human objetivo) {
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
	            this.getHabilidad2().usar(objetivo, 0);
	        }
			else if (this.getHabilidad2().getEfectoManaLanzador()<this.manaActual) {
	            this.getHabilidad2().usar(objetivo, 0);
	            this.manaActual-=this.getHabilidad2().getEfectoManaLanzador();
			}
        }
	}
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
	            this.getHabilidad2().usar(objetivo, 0);
	        }
			else if (this.getHabilidadEspecial().getEfectoManaLanzador()<this.manaActual) {
				this.getHabilidadEspecial().usar(objetivo,0);
				this.manaActual-=this.getHabilidadEspecial().getEfectoManaLanzador();
	            this.useEsp = true;
			}
        }
	}
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

    public void setMana(int cantMana){
        this.manaActual += cantMana;
    }
    //Para una carta:
    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    //Para una carta:
    public void keyCurarse(int cantVida){
        curarse(cantVida);
    }

}
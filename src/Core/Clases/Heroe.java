package Core.Clases;

public class Heroe extends Human{
    //ATRIBUTOS
    protected String clase = "";
    //protected carta = Carta(); Tenemos que crear la clase carta para poder asociarlo
    protected String habilidadEspecial = "";
    protected String[] habilidadesBasicas = new String[2];

    //Herede todos los atributos de la clase humanos que debemos inicializar para cada heroe
    //Contructor de la clase
    public Heroe (String nombre, int vidaBase, int vidaMaxima, int manaMaximo , int manaBase, int danoAtaqueBase, int nivel, int nivelMaximo, int barraExperiencia, int experienciaRequerida, boolean isDead){
        super.nombre = nombre;
        super.vidaBase = vidaBase;
        //super.vidaActual = vidaActual;
        super.vidaMaxima = vidaMaxima;
        super.manaMaximo = manaMaximo;
        super.manaBase = manaBase;
        //super.manaActual = manaActual;
        super.danoAtaqueBase = danoAtaqueBase;
        //super.danoAtaqueActual = danoAtaqueActual;
        super.nivel = nivel;
        super.nivelMaximo = nivelMaximo;
        super.barraExperiencia = barraExperiencia; //Se puede incializar en 0
        super.experienciaRequerida = experienciaRequerida;
        super.isDead = isDead;
    //Los atributos heredados comentados, son utilizados por los metodos, por eso no hace falta inicializarlos, y si los inicializamos tendrian que ser con los valores maximos.
    }    

    //METODOS
    //Por ahora van a devolver el nombre de la habilidad
    protected String usarHabilidadClasica1(){ 
        return this.habilidadesBasicas[0];
    }
    protected String usarHabilidadClasica2(){
        return this.habilidadesBasicas[1];
    }
    protected String usarHabilidadEspecial(){
        return this.habilidadEspecial;
    }

    
    //Esta todavia no devuelve nada porque tenemos que 
    //implementar las funcionalidades
    protected void checkRestriccPrincipal(){
        //Si la restriccion se cumple usa la habilidad especial
        usarHabilidadEspecial();
    } 

    //HEREDAMOS LOS METODOS
    protected int getVida(){
        super.getVida();
    }
    protected int getMana(){
        super.getMana();
    }
    protected int getNivel(){
        super.getNivel();
    }
    protected boolean checkDead(){
        super.checkDead();
    }
    protected void recibirDano() {
    	super.recibirDano();
    };

    protected void usarObjeto(){
        super.usarObjeto();
    }
    
    protected void subirNivel(){
        super.subirNivel();
    }
    
    protected void recuperarMana(){
        super.recuperarMana();
    }
    
    protected void atacarObjetivo(){
        super.atacarObjetivo();
    }
}

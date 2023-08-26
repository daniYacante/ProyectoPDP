package Core.Clases;

abstract class Human {
    //Atributos
    protected String nombre="";
    protected int vida=0;
    protected int mana=0;
    protected int nivel=0;
    protected boolean isDead= false;
    //Metodos
    protected int getVida(){
        return this.vida;
    }
    protected int getMana(){
        return this.mana;
    }
    protected int getNivel(){
        return this.nivel;
    }
    protected boolean checkDead(){
        return this.isDead;
    }
    protected void recibirDaño() {
    	
    };
}
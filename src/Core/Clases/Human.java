package Clases;

abstract class Human {
    //Atributos
    protected String nombre="";
    protected int vida=null;
    protected int mana=null;
    protected int nivel=null;
    protected boolean isDead= False;
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
    protected checkDead(){
        return this.isDead;
    }
    protected recibirDaño();
}
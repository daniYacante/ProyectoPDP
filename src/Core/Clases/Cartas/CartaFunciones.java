package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

public interface CartaFunciones {
    String getNombreCarta();
    void realizarEfecto();

    void imprimirDescripcion();

    void setPortador(Heroe portador);
}

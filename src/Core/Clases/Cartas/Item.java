package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

/**
 * Interface item, quien le va a dar metodos a lo que son Carta y PapelAluminio
 * @see Carta
 * @see papelAluminio
 */
public interface Item {
    /**
     * Se toma el nombre del item
     * @return String
     */
    String getNombreCarta();

    /**
     * Se realiza el efecto del item
     */
    void realizarEfecto();

    /**
     * Se imprime la descripcion del item
     */
    String imprimirDescripcion();

    /**
     * Se setea al portador del item
     * @param portador quien es el que lleve el item
     */

    void setPortador(Heroe portador);
}

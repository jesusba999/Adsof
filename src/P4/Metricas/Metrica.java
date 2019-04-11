package P4.Metricas;

import P4.Exceptions.UsuarioNoRelevante;
import P4.Recomendacion.Recomendacion;

import java.util.Set;

/**
 * Contiene la interfaz Metrica
 *
 * @author Jesus Blanco y Daniel Calonge
 */

public interface Metrica {

    /**
     * Calcula como es de buena una recomendacion para un usuario
     * @param rec Recomendacion
     * @param n Numero de articulos a tener en cuenta
     * @return Puntuacion
     * @throws UsuarioNoRelevante Usuario no relevante
     */
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante;

    /**
     * Devuelve los items cuya puntuacion sea mayor que notaMinima
     * @param u Id del usuario
     * @return Set de items
     */
    public Set<Long> getItemsRelevantes(Long u);
}

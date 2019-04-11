package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.Recomendacion.Recomendacion;

/**
 * Contiene la interfaz Recomendador
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public interface Recomendador {

    /**
     * Hace una recomendacion a un usuario de longitudRecomendacion items
     * @param u Id del usuario
     * @param longitudRecomendacion numero de items
     * @return Recomendacion
     * @throws RecomendacionInvalida Recomendacion invalida
     */
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida;
}

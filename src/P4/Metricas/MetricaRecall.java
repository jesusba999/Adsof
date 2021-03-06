package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;

import java.util.Set;


/**
 * Clase de MetricaRecall
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class MetricaRecall extends MetricaClass {
    /**
     * Constructor de MetricaRecall
     * @param notaMinima Nota minima para que un item sea relevante
     * @param datos Modelo de datos
     */
    public MetricaRecall(double notaMinima, ModeloDatos datos) {
        super(notaMinima, datos);
    }

    /**
     * Calcula la puntuacion de la recomendacion dependiendo de la metrica utilizada
     * @param itemsRelevantes Items con puntuancion por encima de notaminima
     * @param recomendaciones recomendaciones
     * @param n Numero de articulos a tener en cuenta
     * @return puntuacion de la recomendacion
     */
    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){
        Double tamanio = Double.valueOf(itemsRelevantes.size());
        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/tamanio;

    }


}

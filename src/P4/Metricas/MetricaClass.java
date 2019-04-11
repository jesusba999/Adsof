package P4.Metricas;

import P4.Exceptions.UsuarioNoRelevante;
import P4.ModeloDatos.ModeloDatos;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Clase abstracta que implementa metrica
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public abstract class MetricaClass implements Metrica{

    /**
     * Nota minima para que un item sea relevante
     */
    private double notaMinima;

    /**
     * Modelo de datos
     */
    private ModeloDatos datos;

    /**
     * Constructor de MetricaClass
     * @param notaMinima Nota minima para que un item sea relevante
     * @param datos Modelo de datos
     */
    public MetricaClass(double notaMinima, ModeloDatos datos) {
        this.notaMinima = notaMinima;
        this.datos = datos;
    }

    /**
     * Calcula como es de buena una recomendacion para un usuario
     * @param rec Recomendacion
     * @param n Numero de articulos a tener en cuenta
     * @return Puntuacion
     * @throws UsuarioNoRelevante Usuario no relevante
     */
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante {
        Long u = rec.getUsuario();
        Set<Long> itemsRelevantes = getItemsRelevantes(u);

        //Usuario no relevante

        Set<Long> recomendaciones = new HashSet<>();
        int i;

        List<Tupla> tuplas = rec.getRecomendaciones();
        for(i = 0; i < n && i < tuplas.size(); i++){
            recomendaciones.add(tuplas.get(i).getId());
        }
        return calcularMetrica(itemsRelevantes, recomendaciones, Double.valueOf(n));
    }

    /**
     * Devuelve los items cuya puntuacion sea mayor que notaMinima
     * @param u Id del usuario
     * @return Set de items
     */
    public Set<Long> getItemsRelevantes(Long u) {
        Map<Long, Double> preferenciasUsuario = datos.getPreferenciasUsuario(u);
        Set<Long> items = new HashSet<>();
        for(Map.Entry<Long, Double> entrada : preferenciasUsuario.entrySet()){
            if(entrada.getValue() >= notaMinima){
                items.add(entrada.getKey());
            }
        }
        return items;
    }

    /**
     * Calcula la puntuacion de la recomendacion dependiendo de la metrica utilizada
     * @param itemsRelevantes Items con puntuancion por encima de notaminima
     * @param recomendaciones recomendaciones
     * @param n Numero de articulos a tener en cuenta
     * @return puntuacion de la recomendacion
     */
    public abstract Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n );

    /**
     * Devuelve el modelo de datos
     * @return Modelo de datos
     */
    public ModeloDatos getDatos() {
        return datos;
    }
}

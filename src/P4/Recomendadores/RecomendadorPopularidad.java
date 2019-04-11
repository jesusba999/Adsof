package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatosClass;
import P4.ModeloDatos.ModeloDatos;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;


import java.io.IOException;
import java.util.*;


/**
 * Implementa la interfaz Recomendador con la clase RecomendadorPopularidad
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class RecomendadorPopularidad implements Recomendador {
    /**
     * Modelo de datos
     */
    private ModeloDatos datos ;

    /**
     * Constructor de RecomendadorPopularidad
     * @param datos Modelo de datos
     */
    public RecomendadorPopularidad(ModeloDatos datos) {
        this.datos = datos;
    }

    /**
     * Hace una recomendacion a un usuario de longitudRecomendacion items
     * @param u Id del usuario
     * @param longitudRecomendacion numero de items
     * @return Recomendacion
     * @throws RecomendacionInvalida Recomendacion invalida
     */
    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Set<Long> ItemsUnicos = datos.getItemsUnicos();
        List<Tupla> Tuplas = new ArrayList<>();
        for(Long Item : ItemsUnicos){
            if(datos.getPreferenciasUsuario(u).containsKey(Item) == false){
                Map<Long, Double> PreferenciasItem = datos.getPreferenciasItem(Item);
                double sumItem = 0;
                for(Object key : PreferenciasItem.keySet()) {
                    sumItem += 1;
                }
                Tuplas.add(new Tupla(Item, sumItem));
            }
        }

        Collections.sort(Tuplas);

        int i = 0;
        for(Tupla tupla: Tuplas){
            recomendacion.addTupla(tupla);
            i++;
            if(i ==longitudRecomendacion){
                break;
            }
        }


        return recomendacion;
    }
}

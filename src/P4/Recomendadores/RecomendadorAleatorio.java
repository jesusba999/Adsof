package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.*;

/**
 * Implementa la interfaz Recomendador con la clase RecomendadorAleatorio
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class RecomendadorAleatorio implements Recomendador {
    /**
     * Modelo de datos
     */
    private ModeloDatos datos;

    /**
     * Constrictor de RecomendadorAleatorio
     * @param datos Modelo de datos
     */
    public RecomendadorAleatorio(ModeloDatos datos) {
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
        List<Tupla> tuplas = new ArrayList<>();
        for(Long Item : ItemsUnicos){
            if(datos.getPreferenciasUsuario(u).containsKey(Item) == false){
                double sumItem = 5*Math.random();
                tuplas.add(new Tupla(Item, sumItem));
            }
        }

        Collections.sort(tuplas);

        int i = 0;
        for(Tupla tupla: tuplas){
            recomendacion.addTupla(tupla);
            i++;
            if(i ==longitudRecomendacion){
                break;
            }
        }


        return recomendacion;
    }
}

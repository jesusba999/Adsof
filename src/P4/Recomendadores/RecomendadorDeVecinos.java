package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.Map;
import java.util.Set;

public class RecomendadorDeVecinos implements Recomendador{
    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Map<Long, Double> PreferenciasUser = null;    //acceder a modelodatos?

        Set<Long> articulos = null;     //Todos los articulos
        Set<Long> users = null; //Todos los usuarios

        Double score = 0.0;

        for(Long key : articulos) {
            if(PreferenciasUser.containsKey(key) == false) {
                score = 0.0;

                for(Long user : )
                    recomendacion.addTupla(new Tupla(itemId, score));
            }
        }

        return null;
    }
}

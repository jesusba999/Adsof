package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.Map;
import java.util.Set;

public class RecomendadorPopularidad implements Recomendador{

    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Set<Long> ItemsUnicos = ModeloDatosClass.getItemsUnicos;

        for(Long Item : ItemsUnicos){
            Map<Long, Double> PreferenciasItem;
            long sumItem = 0;
            for(Object key : PreferenciasItem.keySet()) {
                sumItem += 1;
            }
            Tupla(Item, sumItem);
        }


        return null;
    }
}

package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecomendadorAleatorio implements Recomendador {
    private ModeloDatos datos = new ModeloDatosClass();

    public RecomendadorAleatorio(ModeloDatos datos) {
        this.datos = datos;
    }

    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Set<Long> ItemsUnicos = datos.getItemsUnicos();
        List<Tupla> Tuplas = new ArrayList<>();
        for(Long Item : ItemsUnicos){
            if(datos.getPreferenciasUsuario(u).containsKey(Item) == false){
                double sumItem = Math.random();
                Tuplas.add(new Tupla(Item, sumItem));
            }
        }

        Tuplas.sort(Tuplas);

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

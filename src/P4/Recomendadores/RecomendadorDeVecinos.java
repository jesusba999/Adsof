package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Similitud.SimilitudCoseno;
import P4.Recomendacion.Tupla;

import java.io.IOException;
import java.util.*;

public class RecomendadorDeVecinos implements Recomendador{

    private ModeloDatos datos;
    private SimilitudCoseno similitudCoseno;

    public RecomendadorDeVecinos(ModeloDatos datos){
        this.datos = datos;
        similitudCoseno = new SimilitudCoseno(datos);
    }

    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Double score = 0.0;
        List<Tupla> tuplas = new ArrayList<>();     //ArrayList con todas las tuplas

        for(Long key : datos.getItemsUnicos()) {
            if(datos.getPreferenciasUsuario(u).containsKey(key) == false) {
                score = 0.0;

                for(Long user : datos.getPreferenciasItem(key).keySet()) {
                    if(user != u) {
                        score += similitudCoseno.sim(u, user) * datos.getPreferenciasUsuario(user).get(key);
                    }
                }

                tuplas.add(new Tupla(key, score));
            }
        }

        Collections.sort(tuplas);

        return recomendacion;
    }
}

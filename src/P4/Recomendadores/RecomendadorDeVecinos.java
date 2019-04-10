package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Similitud.SimilitudCoseno;
import P4.Recomendacion.Tupla;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RecomendadorDeVecinos implements Recomendador{

    private ModeloDatos datos = new ModeloDatosClass();
    private SimilitudCoseno similitudCoseno;

    public RecomendadorDeVecinos(String ruta) throws IOException {
        datos.leeFicheroPreferencias(ruta);
        similitudCoseno = new SimilitudCoseno(ruta);
    }

    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Double score = 0.0;

        for(Long key : datos.getItemsUnicos()) {
            if(datos.getPreferenciasUsuario(u).containsKey(key) == false) {
                score = 0.0;

                for(Long user : datos.getPreferenciasItem(key).keySet()) {
                    if(user != u) {
                        score += similitudCoseno.sim(u, user) * datos.getPreferenciasUsuario(user).get(key);
                    }
                }

                recomendacion.addTupla(new Tupla(key, score));
            }
        }

        return null;
    }
}

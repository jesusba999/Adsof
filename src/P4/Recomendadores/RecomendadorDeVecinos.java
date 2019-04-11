package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Similitud.SimilitudCoseno;
import P4.Recomendacion.Tupla;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RecomendadorDeVecinos implements Recomendador{

    private ModeloDatos datos;
    private SimilitudCoseno similitudCoseno;
    private Integer nVecinos;

    public RecomendadorDeVecinos(ModeloDatos datos, Integer nVecinos){
        this.datos = datos;
        this.nVecinos = nVecinos;
        similitudCoseno = new SimilitudCoseno(datos);
    }

    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        Double score = 0.0;
        List<Tupla> tuplas = new ArrayList<>();     //ArrayList con todas las tuplas de los items con los score
        int i;

        if(datos.getUsuariosUnicos().contains(u) == false || longitudRecomendacion <=0) {
            throw new RecomendacionInvalida();
        }

        for(Long key : datos.getItemsUnicos()) {
            if(datos.getPreferenciasUsuario(u).containsKey(key) == false) {
                score = 0.0;

                List<Tupla> usersSim = new ArrayList<>();   //ArrayList con la similitud de los usuarios

                for(Long user : datos.getPreferenciasItem(key).keySet()) {
                    if(user != u) {
                        usersSim.add(new Tupla(user, similitudCoseno.sim(u, user)));
                    }
                }

                Collections.sort(usersSim);

                i = 0;
                for(Tupla t : usersSim) {
                    score += t.getScore() * datos.getPreferenciasUsuario(t.getId()).get(key);
                    i++;
                    if(i == nVecinos){
                        break;
                    }
                }

                tuplas.add(new Tupla(key, score));
            }
        }

        Collections.sort(tuplas);

        i = 0;
        for(Tupla t : tuplas) {
            recomendacion.addTupla(t);
            i++;
            if(i ==longitudRecomendacion){
                break;
            }
        }

        return recomendacion;
    }
}

package P4.Recomendacion.Similitud;

import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;

import javax.imageio.event.IIOWriteProgressListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilitudCoseno implements Similitud {

    ModeloDatos datos;

    public SimilitudCoseno(ModeloDatos datos) {
        this.datos = datos;
    }

    @Override
    public double sim(Long u1, Long u2) {
        Map<Long, Double> PreferenciasU1 = datos.getPreferenciasUsuario(u1);    //acceder a modelodatos?
        Map<Long, Double> PreferenciasU2 = datos.getPreferenciasUsuario(u2);    //acceder a modelodatos?

        Double sumU1 = 0.0;
        Double sumU2 = 0.0;
        Double sumU1U2 = 0.0;

        for(Object key : PreferenciasU1.keySet()) {
            sumU1 += Math.pow(PreferenciasU1.get(key), 2);  //Suma los ratings al cuadrado de las valoraciones del user1

            if(PreferenciasU2.containsKey(key)) {
                sumU1U2 += PreferenciasU1.get(key) * PreferenciasU2.get(key);   //Suma la multiplicacion de los ratings de los dos users (para un mismo item, solo los que han valorado ambos usuarios)
            }
        }

        for(Object key : PreferenciasU2.keySet()) {
            sumU2 += Math.pow(PreferenciasU2.get(key), 2);  //Suma los ratings al cuadrado de las valoraciones del user2
        }


        return sumU1U2/(Math.sqrt(sumU1*sumU2));
    }
}

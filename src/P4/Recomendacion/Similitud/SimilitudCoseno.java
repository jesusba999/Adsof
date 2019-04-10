package P4.Recomendacion.Similitud;

import P4.ModeloDatos.ModeloDatosClass;

import java.util.Map;

public class SimilitudCoseno implements Similitud {

    @Override
    public double sim(Long u1, Long u2) {
        Map<Long, Double> PreferenciasU1= ModeloDatosClass.getPreferenciasUsuario(u1);
        Map<Long, Double> PreferenciasU2= ModeloDatosClass.getPreferenciasUsuario(u2);
    }
}

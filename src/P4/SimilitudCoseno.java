package P4;

public class SimilitudCoseno implements Similitud {

    @Override
    public double sim(Long u1, Long u2) {
        Map<Long, Double> PreferenciasU1= ModeloDatosClass.getPreferenciasUsuario(u1);
        Map<Long, Double> PreferenciasU2= ModeloDatosClass.getPreferenciasUsuario(u2);
    }
}

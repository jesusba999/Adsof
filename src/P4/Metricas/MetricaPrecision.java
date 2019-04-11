package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;

import java.util.Set;

public class MetricaPrecision extends MetricaClass {


    public MetricaPrecision(double notaMinima, ModeloDatos datos) {
        super(notaMinima, datos);
    }

    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){

        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/n;

    }

}

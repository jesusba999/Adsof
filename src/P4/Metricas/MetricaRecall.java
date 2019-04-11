package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;

import java.util.Set;

public class MetricaRecall extends MetricaClass {

    public MetricaRecall(double notaMinima, ModeloDatos datos) {
        super(notaMinima, datos);
    }

    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){
        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/n;

    }


}

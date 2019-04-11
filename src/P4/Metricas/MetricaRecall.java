package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;

import java.util.Set;

public class MetricaRecall extends MetricaClass {

    public MetricaRecall(double notaMinima, ModeloDatosClass datos) {
        super(notaMinima, datos);
    }

    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){
        Double tamanio = Double.valueOf(itemsRelevantes.size());
        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/tamanio;

    }

}

package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;

import java.util.Set;

public class MetricaPrecision extends MetricaClass {


    public MetricaPrecision(double notaMinima, ModeloDatos datos) {
        super(notaMinima, datos);
    }

    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){
        Double tamanio = Double.valueOf(itemsRelevantes.size());
        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/tamanio;

    }

}

package P4.Metricas;

import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;

import java.util.Set;

public class MetricaPrecision extends MetricaClass {


    public MetricaPrecision(double notaMinima, ModeloDatosClass datos) {
        super(notaMinima, datos);
    }

    public Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n ){

        itemsRelevantes.retainAll(recomendaciones);
        return Double.valueOf(itemsRelevantes.size())/n;

    }

}

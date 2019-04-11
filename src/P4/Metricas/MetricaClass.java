package P4.Metricas;

import P4.Exceptions.UsuarioNoRelevante;
import P4.ModeloDatos.ModeloDatos;
import P4.Recomendacion.Recomendacion;
import P4.Recomendacion.Tupla;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MetricaClass implements Metrica{
    private double notaMinima;
    private ModeloDatos datos;

    public MetricaClass(double notaMinima, ModeloDatos datos) {
        this.notaMinima = notaMinima;
        this.datos = datos;
    }

    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante {
        Long u = rec.getUsuario();
        Set<Long> itemsRelevantes = getItemsRelevantes(u);

        //Usuario no relevante

        Set<Long> recomendaciones = new HashSet<>();
        int i;

        List<Tupla> tuplas = rec.getRecomendaciones();
        for(i = 0; i < n && i < tuplas.size(); i++){
            recomendaciones.add(tuplas.get(i).getId());
        }
        return calcularMetrica(itemsRelevantes, recomendaciones, Double.valueOf(n));
    }

    public Set<Long> getItemsRelevantes(Long u) {
        Map<Long, Double> preferenciasUsuario = datos.getPreferenciasUsuario(u);
        Set<Long> items = new HashSet<>();
        for(Map.Entry<Long, Double> entrada : preferenciasUsuario.entrySet()){
            if(entrada.getValue() >= notaMinima){
                items.add(entrada.getKey());
            }
        }
        return items;
    }

    public abstract Double calcularMetrica(Set<Long> itemsRelevantes, Set<Long> recomendaciones, Double n );

    public ModeloDatos getDatos() {
        return datos;
    }
}

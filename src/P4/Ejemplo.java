package P4;

import java.io.IOException;

import P4.Exceptions.RecomendacionInvalida;
import P4.Exceptions.UsuarioNoRelevante;
import P4.Metricas.MetricaPrecision;
import P4.Metricas.MetricaRecall;
import P4.ModeloDatos.ModeloDatos;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendadores.*;

/**
 * Main de prueba
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Ejemplo {

    public static void main(String[] args) throws IOException {
        RecomendadorDeVecinos recVec = null;



        ModeloDatosClass training = new ModeloDatosClass();
        training.leeFicheroPreferencias("training.txt");


        recVec = new RecomendadorDeVecinos(training,100);

        RecomendadorAleatorio recAl = new RecomendadorAleatorio(training);
        RecomendadorPopularidad recPop = new RecomendadorPopularidad(training);

        ModeloDatosClass test = new ModeloDatosClass();
        test.leeFicheroPreferencias("test.txt");

        MetricaRecall recall = new MetricaRecall(3.0, test);
        MetricaPrecision precision = new MetricaPrecision(3.0, test);

        int usuariosRelevantes= recall.getDatos().getUsuariosUnicos().size();
        double sumaRecallVec = 0.0;
        double sumaPrecisionVec = 0.0;
        double sumaRecallAl = 0.0;
        double sumaPrecisionAl = 0.0;
        double sumaRecallPop = 0.0;
        double sumaPrecisionPop = 0.0;
        int cont = 0;
        System.out.println(recall.getDatos().getUsuariosUnicos());
        for (Long usuario : recall.getDatos().getUsuariosUnicos()) {
            if (cont%10==0) {
                System.out.println(cont+ " usuarios");
            }
            try {
                sumaRecallVec += recall.evalua(recVec.recomienda(usuario, 5),5);
                sumaPrecisionVec += precision.evalua(recVec.recomienda(usuario, 5),5);
            sumaRecallAl += recall.evalua(recAl.recomienda(usuario, 5),5);
            sumaPrecisionAl += precision.evalua(recAl.recomienda(usuario, 5),5);
            sumaRecallPop += recall.evalua(recPop.recomienda(usuario, 5),5);
            sumaPrecisionPop += precision.evalua(recPop.recomienda(usuario, 5),5);
            } catch (RecomendacionInvalida | UsuarioNoRelevante e) {
                usuariosRelevantes--;
            }
            cont++;
        }

        System.out.println("El Recomendador de vecinos segun la metrica Recall: "+sumaRecallVec/usuariosRelevantes);
        //El Recomendador de vecinos segun la metrica Recall: 0.008771929824561403
        //El Recomendador de vecinos segun la metrica Precision: 0.05263157894736842
        System.out.println("El Recomendador de vecinos segun la metrica Precision: "+sumaPrecisionVec/usuariosRelevantes);

    System.out.println("El Recomendador aleatorio segun la metrica Recall: "+sumaRecallAl/usuariosRelevantes);
    System.out.println("El Recomendador aleatorio segun la metrica Precision: "+sumaPrecisionAl/usuariosRelevantes);

    System.out.println("El Recomendador de popularidad segun la metrica Recall: "+sumaRecallPop/usuariosRelevantes);
    System.out.println("El Recomendador de popularidad segun la metrica Precision: "+sumaPrecisionPop/usuariosRelevantes);

    }
}


package P4;

import java.io.IOException;

import P4.Exceptions.RecomendacionInvalida;
import P4.Exceptions.UsuarioNoRelevante;
import P4.Metricas.MetricaPrecision;
import P4.Metricas.MetricaRecall;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendadores.*;

/**
 * Main de prueba
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Test {

    public static void main(String[] args) throws IOException {

        ModeloDatosClass training = new ModeloDatosClass();
        training.leeFicheroPreferencias("training.txt");

        RecomendadorDeVecinos recVec = new RecomendadorDeVecinos(training,100);
        RecomendadorAleatorio recAl = new RecomendadorAleatorio(training);
        RecomendadorPopularidad recPop = new RecomendadorPopularidad(training);

        ModeloDatosClass test = new ModeloDatosClass();
        test.leeFicheroPreferencias("test.txt");

        MetricaRecall recall = new MetricaRecall(3.0, test);
        MetricaPrecision precision = new MetricaPrecision(3.0, test);

        int usuariosRelevantes = recall.getDatos().getUsuariosUnicos().size();
        double sumaRecallVec = 0.0;
        double sumaPrecisionVec = 0.0;
        double sumaRecallAl = 0.0;
        double sumaPrecisionAl = 0.0;
        double sumaRecallPop = 0.0;
        double sumaPrecisionPop = 0.0;

        System.out.println("Procesando Recomendaciones...\n");
        for (Long usuario : recall.getDatos().getUsuariosUnicos()) {

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

        }

        System.out.println("Recomendador De Vecinos Metrica Recall: " + sumaRecallVec/usuariosRelevantes);
        System.out.println("Recomendador De Vecinos Metrica Precision: " + sumaPrecisionVec/usuariosRelevantes);

        System.out.println("Recomendador Aleatorio Metrica Recall: " + sumaRecallAl/usuariosRelevantes);
        System.out.println("Recomendador Aleatorio Metrica Precision: " + sumaPrecisionAl/usuariosRelevantes);

        System.out.println("Recomendador Popularidad Metrica Recall: " + sumaRecallPop/usuariosRelevantes);
        System.out.println("Recomendador Popularidad Metrica Precision: " + sumaPrecisionPop/usuariosRelevantes);

    }
}


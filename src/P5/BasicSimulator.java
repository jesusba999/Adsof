package P5;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la clase del simulador basico
 *
 * @author Jesus Blanco y Daniel Calonge
 */

public class BasicSimulator {

    private Entorno entorno;

    private int tiempo = 0;

    /**
     * Constructor del simulador basico
     * @param nrows numero de filas
     * @param ncols numero de columnas
     */
    public BasicSimulator(int nrows, int ncols) {
        this.entorno =  new Entorno(nrows, ncols);
    }

    public void create(IBasicAgent agent, int numero, int i, int j) throws IllegalPositionException{
        List<IBasicAgent> agentes = new ArrayList<>(numero);

        int k;
        for(k = 0; k < numero; k++){
            agentes.add(agent.copy());
        }

        Cell agentCell = new Cell(i, j , agentes, this);

        if(entorno.getElementAt(i,j) != null){
            ((Cell) (entorno.getElementAt(i, j))).addAgents(listaAgentes);
        }
        else{
            entorno.addElement(agentCell);
        }


    }

    public void run(int pasos) {
        int i;

        for (i = 0; i < pasos; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = " + tiempo);
            System.out.println(entorno);
            tiempo ++;
        }
    }
}

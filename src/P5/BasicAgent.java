package P5;
/**
 * Contiene la clase de un agente basico que implementa la interfaz IBasicAgent
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class BasicAgent implements IBasicAgent{

    /**
     * Celda en la que esta el agente
     */
    private Cell agentCell;

    /**
     * Tipo del agente
     */
    private String tipo;

    /**
     * Constructor de BasicAgent
     * @param tipo tipo del agente
     */
    public BasicAgent(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la celda en la que está el agente
     * @return celda
     */
    public Cell cell(){
        return agentCell;
    }

    /**
     * Hace una copia del agente
     * @return copia
     */
    public IBasicAgent copy(){
        BasicAgent nuevo = new BasicAgent(this.tipo);
        nuevo.agentCell = this.agentCell;

        return nuevo;
    }
}

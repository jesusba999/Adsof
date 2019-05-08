package P5;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Interfaz de IAgent
 *
 * @Author Daniel Calonge y Jesús Blanco
 */

public interface IAgent extends IBasicAgent{
    /**
     * Mover a una celda adyacente
     * @param destination
     */
    void moveTo(Cell destination);

    /**
     * Ejecutar comportamiento del agente
     */
    void exec();


    IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);
    IAgent addBehaviour(Function<IAgent, Boolean> behaviour);

    /**
     * Realiza una copia del agente
     * @return IAgent copia
     */
    IAgent copy();
}


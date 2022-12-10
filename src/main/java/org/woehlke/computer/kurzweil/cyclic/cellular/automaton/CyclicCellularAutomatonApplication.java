package org.woehlke.computer.kurzweil.cyclic.cellular.automaton;

import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.config.ObjectRegistry;
import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.view.CyclicCellularAutomatonFrame;

/**
 * Cyclic Cellular Automaton.
 * <p>
 * (C) 2006 - 2022 Thomas Woehlke.
 * https://java.woehlke.org/cyclic-cellular-automaton
 *
 * @author Thomas Woehlke
 */
public class CyclicCellularAutomatonApplication {

    private CyclicCellularAutomatonApplication() {
    }

    /**
     * Starting the App.
     *
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        ObjectRegistry ctx = new ObjectRegistry();
        CyclicCellularAutomatonFrame frame = new CyclicCellularAutomatonFrame(ctx);
    }
}

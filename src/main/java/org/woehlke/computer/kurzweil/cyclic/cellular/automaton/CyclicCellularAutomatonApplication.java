package org.woehlke.computer.kurzweil.cyclic.cellular.automaton;

import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.config.ObjectRegistry;
import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.view.CyclicCellularAutomatonFrame;

/**
 * Cyclic Cellular Automaton.
 * <p>
 * (C) 2006 - 2022 Thomas Woehlke.
 * @see <a href="https://java.woehlke.org/cyclic-cellular-automaton">Maven Project Page</a>
 *
 * @author Thomas Woehlke
 */
public class CyclicCellularAutomatonApplication {

    private CyclicCellularAutomatonApplication() {
        ObjectRegistry ctx = new ObjectRegistry();
        CyclicCellularAutomatonFrame frame = new CyclicCellularAutomatonFrame(ctx);
    }

    /**
     * Starting the App.
     *
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        CyclicCellularAutomatonApplication application = new CyclicCellularAutomatonApplication();
    }
}

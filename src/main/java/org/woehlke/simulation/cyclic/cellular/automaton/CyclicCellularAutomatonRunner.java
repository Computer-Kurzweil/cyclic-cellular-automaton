package org.woehlke.simulation.cyclic.cellular.automaton;

import org.woehlke.simulation.cyclic.cellular.automaton.view.desktop.CyclicCellularAutomatonFrame;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 */
public class CyclicCellularAutomatonRunner {

    private CyclicCellularAutomatonRunner() { }

    /**
     * Starting the App.
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        CyclicCellularAutomatonFrame frame = new CyclicCellularAutomatonFrame();
    }
}

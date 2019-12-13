package org.woehlke.simulation.cyclic.cellular.automaton.config;

import org.woehlke.simulation.cyclic.cellular.automaton.control.CyclicCellularAutomatonController;
import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;
import org.woehlke.simulation.cyclic.cellular.automaton.view.CyclicCellularAutomatonFrame;
import org.woehlke.simulation.cyclic.cellular.automaton.view.CyclicCellularAutomatonWorldCanvas;

public class ObjectRegistry {

    private CyclicCellularAutomatonController controller;
    private CyclicCellularAutomatonWorldCanvas canvas;
    private CyclicCellularAutomatonLattice lattice;
    private CyclicCellularAutomatonFrame frame;
}

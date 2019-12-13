package org.woehlke.simulation.cyclic.cellular.automaton.config;

import org.woehlke.simulation.cyclic.cellular.automaton.control.CyclicCellularAutomatonController;
import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;
import org.woehlke.simulation.cyclic.cellular.automaton.view.CyclicCellularAutomatonFrame;
import org.woehlke.simulation.cyclic.cellular.automaton.view.CyclicCellularAutomatonCanvas;

public class ObjectRegistry {

    private volatile CyclicCellularAutomatonController controller;
    private volatile CyclicCellularAutomatonCanvas canvas;
    private volatile CyclicCellularAutomatonLattice lattice;
    private volatile CyclicCellularAutomatonFrame frame;
    private volatile Config config;
    private volatile ColorScheme colorScheme;

    public ObjectRegistry() {
        this.config = new Config(this);
        this.lattice = new CyclicCellularAutomatonLattice(this);
        this.canvas = new CyclicCellularAutomatonCanvas(this);
        this.controller = new CyclicCellularAutomatonController(this);
        this.colorScheme = new ColorScheme();
    }

    public CyclicCellularAutomatonController getController() {
        return controller;
    }

    public void setController(CyclicCellularAutomatonController controller) {
        this.controller = controller;
    }

    public CyclicCellularAutomatonCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(CyclicCellularAutomatonCanvas canvas) {
        this.canvas = canvas;
    }

    public CyclicCellularAutomatonLattice getLattice() {
        return lattice;
    }

    public void setLattice(CyclicCellularAutomatonLattice lattice) {
        this.lattice = lattice;
    }

    public CyclicCellularAutomatonFrame getFrame() {
        return frame;
    }

    public void setFrame(CyclicCellularAutomatonFrame frame) {
        this.frame = frame;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }
}

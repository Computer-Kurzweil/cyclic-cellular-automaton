package org.woehlke.simulation.cyclic.cellular.automaton.control;

import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;
import org.woehlke.simulation.cyclic.cellular.automaton.view.WorldCanvas;

import java.io.Serializable;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThread extends Thread
        implements Runnable, Serializable {

    private static final long serialVersionUID = 3642865135701767557L;


    private CyclicCellularAutomatonLattice cyclicCellularAutomatonLattice;
    private WorldCanvas canvas;

    private static final int THREAD_SLEEP_TIME = 100;
    private Boolean goOn;

    public ControllerThread(WorldCanvas canvas, CyclicCellularAutomatonLattice cyclicCellularAutomatonLattice) {
        goOn = Boolean.TRUE;
        this.canvas=canvas;
        this.cyclicCellularAutomatonLattice = cyclicCellularAutomatonLattice;
    }

    public void run() {
        boolean doIt;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            cyclicCellularAutomatonLattice.step();
            canvas.repaint();
            try { sleep(THREAD_SLEEP_TIME); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }


}

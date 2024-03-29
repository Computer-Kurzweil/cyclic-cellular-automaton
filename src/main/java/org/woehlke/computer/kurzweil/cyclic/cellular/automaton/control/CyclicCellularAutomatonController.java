package org.woehlke.computer.kurzweil.cyclic.cellular.automaton.control;

import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.view.CyclicCellularAutomatonFrame;

import java.io.Serializable;

/**
 * Cyclic Cellular Automaton.
 * <p>
 * (C) 2006 - 2022 Thomas Woehlke.
 * @see <a href="https://java.woehlke.org/cyclic-cellular-automaton">Maven Project Page</a>
 *
 * @author Thomas Woehlke
 * <p>
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class CyclicCellularAutomatonController extends Thread
    implements Runnable, Serializable {

    private static final int THREAD_SLEEP_TIME = 100;

    private static final long serialVersionUID = 3642865135701767557L;

    private Boolean goOn;

    private final CyclicCellularAutomatonFrame tab;

    public CyclicCellularAutomatonController(CyclicCellularAutomatonFrame tab) {
        this.tab = tab;
        goOn = Boolean.TRUE;
    }

    public void run() {
        boolean doIt;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            tab.getModel().step();
            tab.getCanvas().repaint();
            tab.repaint();
            try {
                sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }

    public void pushButtonVonNeumann() {
        tab.getModel().startVonNeumann();
    }

    public void pushButtonMoore() {
        tab.getModel().startMoore();
    }

    public void pushButtonWoehlke(){ tab.getModel().startWoehlke();}
}

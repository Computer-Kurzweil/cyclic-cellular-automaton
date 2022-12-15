package org.woehlke.computer.kurzweil.cyclic.cellular.automaton;

import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.config.ComputerKurzweilProperties;
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

    private final CyclicCellularAutomatonFrame frame;

    private CyclicCellularAutomatonApplication() {
        String conf = "application.yml";
        String jarPath = "target/cyclic-cellular-automaton.jar";
        ComputerKurzweilProperties config = ComputerKurzweilProperties.propertiesFactory(conf, jarPath);
        this.frame = new CyclicCellularAutomatonFrame(config);
    }

    public void start(){
        this.frame.start();
    }


    /**
     * Starting the App.
     *
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        CyclicCellularAutomatonApplication application = new CyclicCellularAutomatonApplication();
        application.start();
    }
}

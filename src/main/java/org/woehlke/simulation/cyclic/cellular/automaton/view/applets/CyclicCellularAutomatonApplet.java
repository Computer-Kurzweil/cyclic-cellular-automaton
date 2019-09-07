package org.woehlke.simulation.cyclic.cellular.automaton.view.applets;

import org.woehlke.simulation.cyclic.cellular.automaton.control.ControllerThread;
import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;
import org.woehlke.simulation.cyclic.cellular.automaton.model.Point;
import org.woehlke.simulation.cyclic.cellular.automaton.view.WorldCanvas;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 *
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class CyclicCellularAutomatonApplet extends JApplet implements
    ImageObserver, MenuContainer, Serializable, Accessible {

    private static final long serialVersionUID = 7493461479648193948L;

    private Label title = new Label("cyclic cellular automaton");
    private ControllerThread controllerThread;
    private WorldCanvas canvas;
    private CyclicCellularAutomatonLattice cyclicCellularAutomatonLattice;

    public void init() {
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        Point worldDimensions = new Point(width,height);
        cyclicCellularAutomatonLattice = new CyclicCellularAutomatonLattice(worldDimensions);
        canvas = new WorldCanvas(worldDimensions, cyclicCellularAutomatonLattice);
        this.add(canvas, BorderLayout.CENTER);
        controllerThread = new ControllerThread(canvas, cyclicCellularAutomatonLattice);
        controllerThread.start();
    }

    public void destroy() {
    }

    public void stop() {
    }

    public Point getCanvasDimensions() {
        return canvas.getWorldDimensions();
    }
}

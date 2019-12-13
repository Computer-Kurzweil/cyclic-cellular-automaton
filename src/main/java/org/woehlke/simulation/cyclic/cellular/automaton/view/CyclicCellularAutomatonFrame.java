package org.woehlke.simulation.cyclic.cellular.automaton.view;

import org.woehlke.simulation.cyclic.cellular.automaton.control.CyclicCellularAutomatonController;
import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;
import org.woehlke.simulation.cyclic.cellular.automaton.model.MyPoint;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class CyclicCellularAutomatonFrame extends JFrame implements ImageObserver,
        MenuContainer,
        Serializable,
        Accessible,
        WindowListener {

    private static final long serialVersionUID = 4357793241219932594L;

    private final static String TITLE = "cyclic cellular automaton";

    private final static int WIDTH = 640;
    private final static int HEIGHT = 468;

    private final static int START_X = 100;
    private final static int START_Y = 100;

    private CyclicCellularAutomatonController controller;
    private CyclicCellularAutomatonWorldCanvas canvas;
    private CyclicCellularAutomatonLattice lattice;

    public CyclicCellularAutomatonFrame() {
        super(TITLE);

        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        MyPoint worldDimensions = new MyPoint(width,height);
        lattice = new CyclicCellularAutomatonLattice(worldDimensions);
        canvas = new CyclicCellularAutomatonWorldCanvas(worldDimensions, lattice);
        controller = new CyclicCellularAutomatonController(canvas, lattice);

        JLabel title = new JLabel(TITLE);
        BoxLayout layout = new BoxLayout(rootPane, BoxLayout.PAGE_AXIS);
        rootPane.setLayout(layout);
        rootPane.add(title);
        rootPane.add(canvas);

        addWindowListener(this);
        resetView();
        controller.start();
    }

    private Rectangle getMyBounds(){
        int startX = START_X;
        int startY = START_Y;
        int width = WIDTH;
        int height = HEIGHT + 30;
        return new Rectangle(startX, startY, width , height);
    }

    private MyPoint getWorldDimensions(){
        int width = WIDTH;
        int height = HEIGHT;
        return new MyPoint(width,height);
    }

    private void resetView(){
        pack();
        setBounds(getMyBounds());
        setVisible(true);
        toFront();
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        //System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        resetView();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}

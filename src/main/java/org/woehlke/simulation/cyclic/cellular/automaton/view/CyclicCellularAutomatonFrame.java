package org.woehlke.simulation.cyclic.cellular.automaton.view;

import org.woehlke.simulation.cyclic.cellular.automaton.config.ColorScheme;
import org.woehlke.simulation.cyclic.cellular.automaton.config.CyclicCellularAutomatonConfig;
import org.woehlke.simulation.cyclic.cellular.automaton.config.ObjectRegistry;
import org.woehlke.simulation.cyclic.cellular.automaton.control.CyclicCellularAutomatonController;
import org.woehlke.simulation.cyclic.cellular.automaton.model.CyclicCellularAutomatonLattice;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import static org.woehlke.simulation.cyclic.cellular.automaton.config.CyclicCellularAutomatonConfig.TITLE;

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

    private ObjectRegistry ctx = new ObjectRegistry();

    public CyclicCellularAutomatonFrame() {
        super(TITLE);
        ctx.setFrame(this);
        CyclicCellularAutomatonConfig config = new CyclicCellularAutomatonConfig(ctx);
        ctx.setConfig(config);
        CyclicCellularAutomatonLattice lattice = new CyclicCellularAutomatonLattice(ctx);
        ctx.setLattice(lattice);
        CyclicCellularAutomatonCanvas canvas = new CyclicCellularAutomatonCanvas(ctx);
        ctx.setCanvas(canvas);
        CyclicCellularAutomatonController controller = new CyclicCellularAutomatonController(ctx);
        ctx.setController(controller);
        ColorScheme colorScheme = new ColorScheme();
        ctx.setColorScheme(colorScheme);
        init();
    }

    public void init(){
        JLabel title = new JLabel(TITLE);
        BoxLayout layout = new BoxLayout(rootPane, BoxLayout.PAGE_AXIS);
        rootPane.setLayout(layout);
        rootPane.add(title);
        rootPane.add(ctx.getCanvas());
        addWindowListener(this);
        resetView();
        ctx.getController().start();
    }


    private void resetView(){
        pack();
        setBounds(ctx.getConfig().getMyBounds());
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

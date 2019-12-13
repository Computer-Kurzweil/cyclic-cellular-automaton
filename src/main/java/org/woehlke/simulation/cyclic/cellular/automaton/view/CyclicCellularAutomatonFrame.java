package org.woehlke.simulation.cyclic.cellular.automaton.view;

import org.woehlke.simulation.cyclic.cellular.automaton.config.ObjectRegistry;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import static org.woehlke.simulation.cyclic.cellular.automaton.config.Config.SUBTITLE;
import static org.woehlke.simulation.cyclic.cellular.automaton.config.Config.TITLE;

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
        PanelSubtitle subtitle = new PanelSubtitle(SUBTITLE);
        BoxLayout layout = new BoxLayout(rootPane, BoxLayout.PAGE_AXIS);
        rootPane.setLayout(layout);
        rootPane.add(subtitle);
        rootPane.add(ctx.getCanvas());
        addWindowListener(this);
        ctx.getController().start();
        showMe();
    }

    public void showMe() {
        pack();
        this.setBounds(ctx.getConfig().getFrameBounds());
        setVisible(true);
        toFront();
    }

    public void windowOpened(WindowEvent e) {
        showMe();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent e) { }

    public void windowDeiconified(WindowEvent e) {
        showMe();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
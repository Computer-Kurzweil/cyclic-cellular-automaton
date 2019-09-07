package org.woehlke.simulation.cyclic.cellular.automaton.view;

import org.woehlke.simulation.cyclic.cellular.automaton.model.*;
import org.woehlke.simulation.cyclic.cellular.automaton.model.Point;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;


/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 *
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class WorldCanvas extends JComponent implements Serializable {

    private static final long serialVersionUID = -3057254130516052936L;

    private CyclicCellularAutomatonLattice cyclicCellularAutomatonLattice;
    private Point worldDimensions;

    private Color[] stateColor = new Color[CyclicCellularAutomatonLattice.MAX_STATUS];

    public WorldCanvas(Point worldDimensions, CyclicCellularAutomatonLattice cyclicCellularAutomatonLattice) {
        this.worldDimensions = worldDimensions;
        this.setSize(this.worldDimensions.getX(), this.worldDimensions.getY());
        this.cyclicCellularAutomatonLattice=cyclicCellularAutomatonLattice;
        for(int state = 0; state< CyclicCellularAutomatonLattice.MAX_STATUS; state++){
            switch(state){
                case 0: stateColor[state]=Color.BLACK ; break;
                case 1: stateColor[state]=Color.DARK_GRAY ; break;
                case 2: stateColor[state]=Color.GRAY ; break;
                case 3: stateColor[state]=Color.LIGHT_GRAY ; break;
                case 4: stateColor[state]=Color.WHITE ; break;
                case 5: stateColor[state]=Color.MAGENTA ; break;
                case 6: stateColor[state]=Color.RED ; break;
                case 7: stateColor[state]=Color.ORANGE ; break;
                case 8: stateColor[state]=Color.YELLOW ; break;
                case 9: stateColor[state]=Color.PINK ; break;
                case 10: stateColor[state]=Color.BLUE ; break;
                case 11: stateColor[state]=Color.CYAN ; break;
                case 12: stateColor[state]=Color.GREEN ; break;
            }
        }
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        for(int y=0;y<worldDimensions.getY();y++){
            for(int x=0;x<worldDimensions.getX();x++){
                int state = cyclicCellularAutomatonLattice.getCellStatusFor(x,y);
                 g.setColor(stateColor[state]);
                 g.drawLine(x,y,x,y);
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public Point getWorldDimensions() {
        return worldDimensions;
    }
}

package org.woehlke.simulation.cyclic.cellular.automaton.config;

import java.awt.*;

import static org.woehlke.simulation.cyclic.cellular.automaton.config.CyclicCellularAutomatonConfig.MAX_STATUS;

public class ColorScheme {

    private Color[] stateColor = new Color[MAX_STATUS];

    public ColorScheme(){
        for(int state = 0; state < MAX_STATUS; state++){
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

    public Color getColorForState(int state){
        return stateColor[state];
    }
}

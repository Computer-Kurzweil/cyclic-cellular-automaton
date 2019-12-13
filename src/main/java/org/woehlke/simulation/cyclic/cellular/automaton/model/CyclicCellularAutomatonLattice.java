package org.woehlke.simulation.cyclic.cellular.automaton.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Cyclic Cellular Automaton.
 *
 * Created with IntelliJ IDEA.
 * Date: 28.08.13
 * Time: 12:39
 */
public class CyclicCellularAutomatonLattice implements Serializable {

    private static final long serialVersionUID = -594681595882016258L;

    public final static int MAX_STATUS = 13;
    private MyPoint worldDimensions;
    private Random random;

    private int[][][] lattice;
    private volatile int source;
    private volatile int target;


    public CyclicCellularAutomatonLattice(MyPoint worldDimensions) {
        this.worldDimensions = worldDimensions;
        random = new Random(new Date().getTime());
        lattice = new int[2][worldDimensions.getX()][worldDimensions.getY()];
        source = 0;
        target = 1;
        for(int y=0;y<worldDimensions.getY();y++){
            for(int x=0;x<worldDimensions.getX();x++){
                lattice[source][x][y] = random.nextInt(MAX_STATUS);
            }
        }
    }

    public void step(){
        //System.out.print(".");
        for(int y=0;y<worldDimensions.getY();y++){
            for(int x=0;x<worldDimensions.getX();x++){
                lattice[target][x][y] = lattice[source][x][y];
                int nextState = (lattice[source][x][y] + 1) % MAX_STATUS;
                if(nextState == lattice[source][x][(y-1+worldDimensions.getY())%worldDimensions.getY()]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][(x+1+worldDimensions.getX())%worldDimensions.getX()][y]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][x][(y+1+worldDimensions.getY())%worldDimensions.getY()]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][(x-1+worldDimensions.getX())%worldDimensions.getX()][y]){
                    lattice[target][x][y] = nextState;
                }
            }
        }
        source = (source + 1 ) % 2;
        target = (target + 1 ) % 2;
    }

    public int getCellStatusFor(int x,int y){
        return lattice[source][x][y];
    }
}

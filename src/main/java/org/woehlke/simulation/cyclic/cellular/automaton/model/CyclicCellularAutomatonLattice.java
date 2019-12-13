package org.woehlke.simulation.cyclic.cellular.automaton.model;

import org.woehlke.simulation.cyclic.cellular.automaton.config.ObjectRegistry;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import static org.woehlke.simulation.cyclic.cellular.automaton.config.Config.MAX_STATUS;

/**
 * Cyclic Cellular Automaton.
 *
 * Created with IntelliJ IDEA.
 * Date: 28.08.13
 * Time: 12:39
 */
public class CyclicCellularAutomatonLattice implements Serializable {

    private static final long serialVersionUID = -594681595882016258L;

    private Random random;

    private volatile int[][][] lattice;
    private volatile int source;
    private volatile int target;

    private final ObjectRegistry ctx;

    public CyclicCellularAutomatonLattice(ObjectRegistry ctx) {
        this.ctx = ctx;
        random = new Random(new Date().getTime());
        initCreateLattice();
        initFillLatticeByRandom();
    }

    private void initCreateLattice(){
        lattice = new int[2]
            [(int) this.ctx.getConfig().getLatticeDimensions().getX()]
            [(int) this.ctx.getConfig().getLatticeDimensions().getY()];
        source = 0;
        target = 1;
    }

    private void initFillLatticeByRandom(){
        for(int y = 0; y<this.ctx.getConfig().getLatticeDimensions().getY(); y++){
            for(int x = 0; x<this.ctx.getConfig().getLatticeDimensions().getX(); x++){
                lattice[source][x][y] = random.nextInt(MAX_STATUS);
            }
        }
    }

    public void step(){
        //System.out.print(".");
        Point worldDimensions = this.ctx.getConfig().getLatticeDimensions();
        for(int y = 0; y < worldDimensions.getY(); y++){
            for(int x = 0; x < worldDimensions.getX(); x++){
                lattice[target][x][y] = lattice[source][x][y];
                int nextState = (lattice[source][x][y] + 1) % MAX_STATUS;
                if(nextState == lattice[source][x][(int) ((y-1+worldDimensions.getY())%worldDimensions.getY())]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][(int) ((x+1+worldDimensions.getX())%worldDimensions.getX())][y]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][x][(int) ((y+1+worldDimensions.getY())%worldDimensions.getY())]){
                    lattice[target][x][y] = nextState;
                    continue;
                }
                if(nextState == lattice[source][(int) ((x-1+worldDimensions.getX())%worldDimensions.getX())][y]){
                    lattice[target][x][y] = nextState;
                }
            }
        }
        this.source = (this.source + 1 ) % 2;
        this.target =  (this.target + 1 ) % 2;
    }

    public int getCellStatusFor(int x,int y){
        return this.lattice[source][x][y];
    }
}

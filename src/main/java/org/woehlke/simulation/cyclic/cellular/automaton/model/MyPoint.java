package org.woehlke.simulation.cyclic.cellular.automaton.model;

import java.io.Serializable;


/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 *
 * Date: 04.02.2006
 * Time: 23:47:05
 */
public class MyPoint implements Serializable {

    private static final long serialVersionUID = 5851950573378851027L;

    private int x = 0;
    private int y = 0;

    public MyPoint(MyPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void killNagative() {
        if (y < 0) {
            y *= -1;
        }
        if (x < 0) {
            x *= -1;
        }
    }

    public void add(MyPoint p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void normalize(MyPoint p) {
        this.x %= p.getX();
        this.y %= p.getY();
    }

    public MyPoint[] getNeighbourhood(MyPoint max){
        MyPoint neighbourhood[] = new MyPoint[9];
        int maxX = max.getX();
        int maxY = max.getY();
        neighbourhood[0]= new MyPoint((this.x+maxX-1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[1]= new MyPoint((this.x+maxX-1) % maxX,this.y);
        neighbourhood[2]= new MyPoint((this.x+maxX-1) % maxX,(this.y+maxY+1) % maxY);
        neighbourhood[3]= new MyPoint(this.x,(this.y+maxY-1) % maxY);
        neighbourhood[4]= new MyPoint(this.x,this.y);
        neighbourhood[5]= new MyPoint(this.x,(this.y+maxY+1) % maxY);
        neighbourhood[6]= new MyPoint((this.x+maxX+1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[7]= new MyPoint((this.x+maxX+1) % maxX,this.y);
        neighbourhood[8]= new MyPoint((this.x+maxX+1) % maxX,(this.y+maxY+1) % maxY);
        return neighbourhood;
    }
}

package org.woehlke.simulation.cyclic.cellular.automaton.config;

import org.woehlke.simulation.cyclic.cellular.automaton.model.MyPoint;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CyclicCellularAutomatonConfig {

    public final static String TITLE = "cyclic cellular automaton";

    private final static int TITLE_HEIGHT = 30;

    private final static int WIDTH = 640;
    private final static int HEIGHT = 468;

    private final static int START_X = 100;
    private final static int START_Y = 100;

    public static final int THREAD_SLEEP_TIME = 100;

    public final static int MAX_STATUS = 13;

    private final ObjectRegistry ctx;

    public CyclicCellularAutomatonConfig(final ObjectRegistry ctx) {
        this.ctx = ctx;
        try (
            InputStream input = new FileInputStream("application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public Rectangle getMyBounds(){
        return new Rectangle(START_X, START_Y, WIDTH , HEIGHT + TITLE_HEIGHT);
    }

    public MyPoint getWorldDimensions(){
        return new MyPoint(WIDTH,HEIGHT);
    }

}

package org.woehlke.simulation.cyclic.cellular.automaton.config;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.io.File.*;

public class Config {

    public final static String TITLE = "cyclic cellular automaton";

    public final static String SUBTITLE = "cyclic cellular automaton";

    private final static int TITLE_HEIGHT = 30;

    private final static int WIDTH = 640;
    private final static int HEIGHT = 468;

    private final static int START_X = 100;
    private final static int START_Y = 100;

    public static final int THREAD_SLEEP_TIME = 100;

    public final static int MAX_STATUS = 13;

    private final ObjectRegistry ctx;

    public Config(final ObjectRegistry ctx) {
        this.ctx = ctx;
        String appPropertiesFile = ("src" + separator +"main" + separator + "resources" + separator  + "application.properties");
        Properties prop = new Properties();
        try (
            InputStream input = new FileInputStream(appPropertiesFile)) {
            prop.load(input);
            for( Object key : prop.keySet()){
                System.out.println(prop.get(key).toString());
            }
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public Rectangle getFrameBounds(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = HEIGHT;
        double width = WIDTH;
        double startX = (screenSize.getWidth() - height) / 2d;
        double startY = (screenSize.getHeight() - width) / 2d;
        int myheight = Double.valueOf(height).intValue()+TITLE_HEIGHT;
        int mywidth = Double.valueOf(width).intValue();
        int mystartX = Double.valueOf(startX).intValue();
        int mystartY = Double.valueOf(startY).intValue();
        return new Rectangle(mystartX, mystartY, mywidth, myheight);
    }

    public Rectangle getCanvasBounds(){
        return new Rectangle(0, 0, WIDTH , HEIGHT);
    }

    public Point getLatticeDimensions(){
        return new Point(WIDTH,HEIGHT);
    }

    public String getSubtitle(){
        return SUBTITLE;
    }

}

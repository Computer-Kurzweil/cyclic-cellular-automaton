package org.woehlke.computer.kurzweil.cyclic.cellular.automaton.view;

import org.woehlke.computer.kurzweil.cyclic.cellular.automaton.config.ObjectRegistry;

import javax.swing.*;
import java.awt.*;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2022 Thomas Woehlke.
 * https://woehlke.org/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 */
public class PanelSubtitle extends JPanel {

    private static final long serialVersionUID = 242L;

  private final JLabel subtitleLabel;

  public PanelSubtitle(ObjectRegistry ctx) {
    this.subtitleLabel = new JLabel(ctx.getConfig().getSubtitle());
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(subtitleLabel);
  }

}

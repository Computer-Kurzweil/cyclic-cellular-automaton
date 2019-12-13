package org.woehlke.simulation.cyclic.cellular.automaton.view;

import javax.swing.*;
import java.awt.*;

/**
 * TODO write doc.
 */
public class PanelSubtitle extends JPanel {

  private final JLabel subtitleLabel;

  public PanelSubtitle(String subtitle) {
    this.subtitleLabel = new JLabel(subtitle);
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(subtitleLabel);
  }

}

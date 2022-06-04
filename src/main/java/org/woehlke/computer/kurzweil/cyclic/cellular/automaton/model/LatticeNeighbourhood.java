package org.woehlke.computer.kurzweil.cyclic.cellular.automaton.model;

/**
 * Cyclic Cellular Automaton.
 *
 * (C) 2006 - 2022 Thomas Woehlke.
 * https://woehlke.org/p/cyclic-cellular-automaton/
 * @author Thomas Woehlke
 */
public enum LatticeNeighbourhood {

    /**
     * https://en.wikipedia.org/wiki/Von_Neumann_neighborhood
     */
    VON_NEUMANN_NEIGHBORHOOD,

    /**
     * https://en.wikipedia.org/wiki/Moore_neighborhood
     */
    MOORE_NEIGHBORHOOD,

    WOEHLKE_NEIGHBORHOOD;
}

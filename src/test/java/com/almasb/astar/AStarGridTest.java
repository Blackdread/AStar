package com.almasb.astar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AStarGridTest {

    private static final int GRID_SIZE = 20;
    private AStarGrid grid;

    @Before
    public void setUp() {
        grid = new AStarGrid(GRID_SIZE, GRID_SIZE);
    }

    @Test
    public void testIsWithin() throws Exception {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                assertTrue(grid.isWithin(j, i));
            }
        }

        assertFalse(grid.isWithin(GRID_SIZE, 0));
        assertFalse(grid.isWithin(0, GRID_SIZE));
    }

    @Test
    public void testGetNodeState() throws Exception {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                assertEquals(NodeState.WALKABLE, grid.getNodeState(j, i));
            }
        }
    }

    @Test
    public void testGetPath() throws Exception {

    }

    @Test
    public void testGetNode() throws Exception {

    }
}
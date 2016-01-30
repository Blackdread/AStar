package com.almasb.astar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        List<AStarNode> path = grid.getPath(3, 0, 5, 0);
        assertPathEquals(path,
                4, 0,
                5, 0);

        for (int i = 0; i <= 4; i++)
            grid.setNodeState(4, i, NodeState.NOT_WALKABLE);

        path = grid.getPath(3, 0, 5, 0);
        assertPathEquals(path,
                3, 1,
                3, 2,
                3, 3,
                3, 4,
                3, 5,
                4, 5,
                5, 5,
                5, 4,
                5, 3,
                5, 2,
                5, 1,
                5, 0);

        for (int i = 0; i <= 19; i++)
            grid.setNodeState(4, i, NodeState.NOT_WALKABLE);

        path = grid.getPath(3, 0, 5, 0);
        assertTrue(path.isEmpty());
    }

    private void assertPathEquals(List<AStarNode> path, int... points) {
        assertEquals(points.length / 2, path.size());

        int i = 0;
        for (AStarNode node : path) {
            assertEquals(points[i++], node.getX());
            assertEquals(points[i++], node.getY());
        }

        assertEquals(points.length, i);
    }
}
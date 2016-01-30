package com.almasb.astar.maze;

/**
 * Represents a single cell in a maze.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class MazeCell {
    private int x, y;
    private boolean topWall = false, leftWall = false;

    public MazeCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public boolean hasLeftWall() {
        return leftWall;
    }

    public boolean hasTopWall() {
        return topWall;
    }
}

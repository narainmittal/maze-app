package com.nmittal.maze.domain;

import com.nmittal.maze.solve.IMazeSolver;

/**
 * Provides the skeleton implementation for a Block in a Maze
 * 
 * @author Narain Mittal
 * 
 */
public abstract class Block {

	private final Color color;

	private final int x;

	private final int y;

	public Block(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public abstract String display(IMazeSolver solver);

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/*
	 * 2 Blocks are considered equal if they are at same index.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Block other = (Block) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + x;
		result = (prime * result) + y;
		return result;
	}

	@Override
	public String toString() {
		return "Block [x=" + x + ", y=" + y + "]";
	}

}

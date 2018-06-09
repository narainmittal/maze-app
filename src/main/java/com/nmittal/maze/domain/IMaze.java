package com.nmittal.maze.domain;

import com.nmittal.maze.solve.IMazeSolver;

/**
 * Maze interface provides skeleton for Maze data structure.
 * 
 * @author Narain Mittal
 * 
 */
public interface IMaze {

	/**
	 * @return Start Block
	 */
	public Block getStart();

	/**
	 * @return End block
	 */
	public Block getEnd();

	/**
	 * Returns String representation of Maze
	 * 
	 * @return String
	 */
	public String display(IMazeSolver solver);

	public Block getBlock(int x, int y);

}

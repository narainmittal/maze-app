package com.nmittal.maze.solve;

import java.util.Set;

import com.nmittal.maze.domain.Block;

/**
 * Interface for any algorithm implementation for solving Maze problem
 * 
 * @author Narain Mittal
 * 
 */
public interface IMazeSolver {

	/**
	 * @return
	 */
	boolean solve();

	/**
	 * @return
	 */
	long solutionPathSize();

	/**
	 * @param block
	 *
	 * @return true if the block is part of the solution path/ false otherwise
	 */
	boolean isBlockInSolution(Block block);

	/**
	 * @param block
	 *
	 * @return true if the block has been visited in the maze/ false otherwise
	 */
	boolean isBlockVisited(Block block);

	Set<Block> getSolutionPath();

}

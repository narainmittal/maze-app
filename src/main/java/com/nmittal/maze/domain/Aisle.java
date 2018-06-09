package com.nmittal.maze.domain;

import com.nmittal.maze.solve.IMazeSolver;

/**
 * Implementation of Aisle object.
 * 
 * @author Narain Mittal
 * 
 */
public class Aisle extends Block {

	public Aisle(int x, int y) {
		super(Color.WHITE, x, y);
	}

	@Override
	public String display(IMazeSolver solver) {
		return (solver != null && solver.isBlockInSolution(this)) ? " * " : "   ";
	}

}

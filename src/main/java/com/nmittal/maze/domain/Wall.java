package com.nmittal.maze.domain;

import com.nmittal.maze.solve.IMazeSolver;

/**
 * 
 * Implementation of Wall object.
 * 
 * @author Narain Mittal
 * 
 */
public class Wall extends Block {

	public Wall(int x, int y) {
		super(Color.GREEN, x, y);
	}

	@Override
	public String display(IMazeSolver solver) {
		return "xxx";
	}

}

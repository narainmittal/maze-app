package com.nmittal.mazeapp.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.nmittal.maze.Block;
import com.nmittal.maze.IMaze;
import com.nmittal.maze.IMazeSolver;
import com.nmittal.maze.MazeBuilder;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.util.SolutionFactory;

@Service
public class MazeService implements IMazeService {

	private IMaze localMaze;

	@Override
	public IMaze getMaze() {
		if (null == localMaze) {
			initializeMaze();
		}
		return localMaze;
	}

	@Override
	public Set<Block> solveMaze(SolutionAlgorithms algorithm) {
		IMazeSolver solver = SolutionFactory.getMazeSolver(algorithm, getMaze());
		boolean solutionAvailable = solver.solve();
		if (solutionAvailable) {
			return solver.getSolutionPath();
		}
		return null;
	}

	@Override
	public SolutionAlgorithms[] getAvailableAlgorithms() {

		return SolutionAlgorithms.values();
	}

	private void initializeMaze() {
		// @formatter:off
		int[][] data = new int[][] { { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, };
		// @formatter:on
		localMaze = MazeBuilder.buildMaze(data, 0, 2, 15, 14);
	}

}

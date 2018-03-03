package com.nmittal.mazeapp.util;

import java.util.Optional;

import com.nmittal.maze.IMaze;
import com.nmittal.maze.IMazeSolver;
import com.nmittal.maze.MazeSolverBfs;
import com.nmittal.maze.MazeSolverDfs;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;

public class SolutionFactory {

	public static IMazeSolver getMazeSolver(SolutionAlgorithms algorithm, IMaze maze) {
		IMazeSolver solver = null;

		algorithm = Optional.ofNullable(algorithm).orElseThrow(() -> new MazeException("Invalid value for algorithm"));

		switch (algorithm) {
		case BFS:
			solver = new MazeSolverBfs(maze);
			break;
		case DFS:
			solver = new MazeSolverDfs(maze);
			break;
		default:
			throw new MazeException("Invalid value for algorithm");
		}

		return solver;
	}
}

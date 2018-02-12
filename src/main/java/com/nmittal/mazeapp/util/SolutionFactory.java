package com.nmittal.mazeapp.util;

import com.nmittal.maze.IMaze;
import com.nmittal.maze.IMazeSolver;
import com.nmittal.maze.MazeSolverBfs;
import com.nmittal.maze.MazeSolverDfs;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;

public class SolutionFactory {

	public static IMazeSolver getMazeSolver(SolutionAlgorithms algorithm, IMaze maze) {
		IMazeSolver solver = null;
		switch (algorithm) {
		case BFS:
			solver = new MazeSolverBfs(maze);
		case DFS:
			solver = new MazeSolverDfs(maze);
		}
		return solver;
	}
}

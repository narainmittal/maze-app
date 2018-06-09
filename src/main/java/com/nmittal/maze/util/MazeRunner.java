package com.nmittal.maze.util;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.maze.generator.IMazeGenerator;
import com.nmittal.maze.generator.MazeGeneratorRecursive;
import com.nmittal.maze.solve.IMazeSolver;
import com.nmittal.maze.solve.MazeSolverBfs;
import com.nmittal.maze.solve.MazeSolverDfs;

/**
 * Test program to run the Maze problem
 * 
 * @author Narain Mittal
 * 
 */
public class MazeRunner {

	public static void main(String[] args) {

		IMazeGenerator generator = new MazeGeneratorRecursive();
		IMaze maze = generator.generateMaze(20, 20);

		System.out.println("-------------DFS---------------");
		IMazeSolver solver = new MazeSolverDfs(maze);
		long startTime = System.currentTimeMillis();
		System.out.println(solver.solve());
		long endTime = System.currentTimeMillis();
		System.out.println(maze.display(solver));
		System.out.println("Solution path size: " + solver.solutionPathSize());
		System.out.println("Time taken " + (endTime - startTime));

		System.out.println("-------------BFS---------------");
		solver = new MazeSolverBfs(maze);
		startTime = System.currentTimeMillis();
		System.out.println(solver.solve());
		endTime = System.currentTimeMillis();
		System.out.println(maze.display(solver));
		System.out.println("Solution path size: " + solver.solutionPathSize());
		System.out.println("Time taken " + (endTime - startTime));

	}
}

package com.nmittal.maze.solve;

import org.junit.Assert;
import org.junit.Test;

import com.nmittal.maze.domain.Aisle;
import com.nmittal.maze.domain.Block;
import com.nmittal.maze.domain.Maze;
import com.nmittal.maze.domain.Wall;
import com.nmittal.maze.util.MazeBuilder;

/**
 * JUnit to test the Maze
 * 
 * @author Narain Mittal
 * 
 */
public class MazeBfsTest {

	private IMazeSolver bfs;

	@Test(expected = IllegalArgumentException.class)
	public void testInsufficientMazeDataException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		bfs = new MazeSolverBfs(maze);
		bfs.solve();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeDataException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 2 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		bfs = new MazeSolverBfs(maze);
		bfs.solve();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeDataException2() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		bfs = new MazeSolverBfs(maze);
		bfs.solve();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeStartException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 5, 5, 3, 1);
		bfs = new MazeSolverBfs(maze);
		bfs.solve();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMazeEndException() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 5, 5);
		bfs = new MazeSolverBfs(maze);
		bfs.solve();
	}

	@Test
	public void testMazeSolution() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 1);
		bfs = new MazeSolverBfs(maze);
		Assert.assertTrue(bfs.solve());
		Block[][] blocks = maze.getBlocks();
		for (Block[] bl : blocks) {
			for (Block b : bl) {
				if (b instanceof Wall) {
					Assert.assertFalse(bfs.isBlockVisited(b));
					Assert.assertFalse(bfs.isBlockInSolution(b));
				} else if (b instanceof Aisle) {
					Assert.assertTrue(bfs.isBlockVisited(b));
					Assert.assertTrue(bfs.isBlockInSolution(b));
				}
			}
		}
	}

	@Test
	public void testMazeNoSolution() {
		int[][] data = new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		Maze maze = MazeBuilder.buildMaze(data, 0, 1, 3, 2);
		bfs = new MazeSolverBfs(maze);
		Assert.assertFalse(bfs.solve());
	}

}

package com.nmittal.maze.generator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.maze.solve.IMazeSolver;
import com.nmittal.maze.solve.MazeSolverBfs;
import com.nmittal.maze.solve.MazeSolverDfs;

public class MazeGeneratorRecursiveTest {

	private static final Logger LOG = LoggerFactory.getLogger(MazeGeneratorRecursiveTest.class);

	private IMazeGenerator generator;

	@Rule
	public ExpectedException exceptionGrabber = ExpectedException.none();

	@Before
	public void setup() {
		generator = new MazeGeneratorRecursive();

	}

	@Test
	public void errorWithNegativeValues() {
		int grid = -2;

		exceptionGrabber.expect(IllegalArgumentException.class);
		exceptionGrabber.expectMessage("Invalid grid values");
		generator.generateMaze(grid, grid);
	}

	@Test
	public void errorWithGridLessThanMin() {
		int grid = MazeGeneratorRecursive.MIN_GRID - 1;

		exceptionGrabber.expect(IllegalArgumentException.class);
		exceptionGrabber.expectMessage("Invalid grid values");
		generator.generateMaze(grid, grid);
	}

	@Test
	public void errorWithGridMoreThanMaz() {
		int grid = MazeGeneratorRecursive.MAX_GRID + 1;

		exceptionGrabber.expect(IllegalArgumentException.class);
		exceptionGrabber.expectMessage("Invalid grid values");
		generator.generateMaze(grid, grid);
	}

	@Test
	public void mazeGeneratorValidArgs() {
		int grid = 20;
		try {
			IMaze maze = generator.generateMaze(grid, grid);
			assertThat("should have the size as input", maze.getBlock(grid - 1, grid - 1), notNullValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not throw error in maze generation");
		}
	}

	@Test
	public void mazeGenerateAndSolve() {
		int grid = 20;
		try {
			IMaze maze = generator.generateMaze(grid, grid);
			IMazeSolver bfs = new MazeSolverBfs(maze);
			IMazeSolver dfs = new MazeSolverDfs(maze);

			assertThat(bfs.solve(), equalTo(true));
			assertThat(dfs.solve(), equalTo(true));

			LOG.info("BFS solution");
			LOG.info("\n" + maze.display(bfs));
			LOG.info("DFS solution");
			LOG.info("\n" + maze.display(dfs));
			maze.display(dfs);

		} catch (Exception e) {
			e.printStackTrace();
			fail("should not throw error in maze solution");
		}
	}

}

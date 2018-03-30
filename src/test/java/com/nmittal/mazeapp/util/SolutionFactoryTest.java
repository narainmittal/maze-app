package com.nmittal.mazeapp.util;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.maze.domain.Maze;
import com.nmittal.maze.solve.MazeSolverBfs;
import com.nmittal.maze.solve.MazeSolverDfs;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class SolutionFactoryTest {

	@Test
	public void getMazeSolver() {

		IMaze maze = new Maze(null, null, null);

		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(SolutionFactory.getMazeSolver(SolutionAlgorithms.BFS, maze))
				.isInstanceOf(MazeSolverBfs.class);

		softly.assertThat(SolutionFactory.getMazeSolver(SolutionAlgorithms.DFS, maze))
				.isInstanceOf(MazeSolverDfs.class);

		softly.assertThatThrownBy(() -> SolutionFactory.getMazeSolver(null, maze)).isInstanceOf(MazeException.class)
				.hasMessage("Invalid value for algorithm");

		softly.assertAll();
	}

}

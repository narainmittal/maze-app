package com.nmittal.mazeapp.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.nmittal.maze.IMaze;
import com.nmittal.maze.Maze;
import com.nmittal.maze.MazeSolverBfs;
import com.nmittal.maze.MazeSolverDfs;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class SolutionFactoryTest {

	@Test
	public void getMazeSolver() {

		IMaze maze = new Maze(null, null, null);

		assertThat(SolutionFactory.getMazeSolver(SolutionAlgorithms.BFS, maze)).isInstanceOf(MazeSolverBfs.class);

		assertThat(SolutionFactory.getMazeSolver(SolutionAlgorithms.DFS, maze)).isInstanceOf(MazeSolverDfs.class);

		assertThatThrownBy(() -> SolutionFactory.getMazeSolver(null, maze)).isInstanceOf(MazeException.class)
				.hasMessage("Invalid value for algorithm");
	}

}
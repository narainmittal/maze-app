package com.nmittal.maze.generator;

import com.nmittal.maze.domain.IMaze;

public interface IMazeGenerator {

	IMaze generateMaze(int gridRows, int gridColumns);

	boolean validate(int gridRows, int gridColumns);
}

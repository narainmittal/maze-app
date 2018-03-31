package com.nmittal.mazeapp.dao;

import com.nmittal.maze.domain.IMaze;

public interface IMazeDao {

	IMaze createMaze(int rows, int cols);

	IMaze getMaze(long mazeId);

}

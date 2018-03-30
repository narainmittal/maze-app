package com.nmittal.mazeapp.dao;

import com.nmittal.maze.domain.IMaze;

public interface IMazeDao {

	IMaze createMaze();

	IMaze getMaze(long mazeId);

}

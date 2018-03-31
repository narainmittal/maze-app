package com.nmittal.mazeapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.maze.generator.IMazeGenerator;
import com.nmittal.maze.generator.MazeGeneratorRecursive;

@Repository
public class LocalMazeDao implements IMazeDao {

	private static final Logger log = LoggerFactory.getLogger(LocalMazeDao.class);

	private IMaze localMaze;

	private static final int DEFULT_GRID = 20;

	@Override
	public IMaze createMaze(int rows, int cols) {
		IMazeGenerator generator = new MazeGeneratorRecursive();
		localMaze = generator.generateMaze(rows, cols);
		return localMaze;
	}

	@Override
	public IMaze getMaze(long mazeId) {
		if (null == localMaze) {
			log.info("Creating default 20*20 Maze...");
			localMaze = createMaze(DEFULT_GRID, DEFULT_GRID);
		}
		return localMaze;
	}

}

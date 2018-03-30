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

	@Override
	public IMaze createMaze() {
		IMazeGenerator generator = new MazeGeneratorRecursive();
		return generator.generateMaze(20, 20);
	}

	@Override
	public IMaze getMaze(long mazeId) {
		if (null == localMaze) {
			log.info("Creating Maze...");
			localMaze = createMaze();
		}
		return localMaze;
	}

}

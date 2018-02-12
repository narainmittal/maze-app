package com.nmittal.mazeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.tr.maze.Block;
import com.tr.maze.IMaze;
import com.tr.maze.MazeBuilder;

@Service
public class MazeService implements IMazeService {

	private IMaze localMaze;

	@Override
	public IMaze getMaze() {
		if (null == localMaze) {
			initializeMaze();
		}
		return localMaze;
	}

	@Override
	public List<Block> solveMaze(SolutionAlgorithms algorithm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolutionAlgorithms[] getAvailableAlgorithms() {
		// TODO Auto-generated method stub
		return SolutionAlgorithms.values();
	}

	private void initializeMaze() {
		// @formatter:off
		int[][] data = new int[][] { { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, };
		// @formatter:on
		localMaze = MazeBuilder.buildMaze(data, 0, 2, 15, 14);
	}

}

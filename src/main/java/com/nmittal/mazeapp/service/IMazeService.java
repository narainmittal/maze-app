package com.nmittal.mazeapp.service;

import java.util.List;

import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.tr.maze.Block;
import com.tr.maze.IMaze;

public interface IMazeService {

	IMaze getMaze();

	List<Block> solveMaze(SolutionAlgorithms algorithm);

	SolutionAlgorithms[] getAvailableAlgorithms();

}

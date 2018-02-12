package com.nmittal.mazeapp.service;

import java.util.Set;

import com.nmittal.maze.Block;
import com.nmittal.maze.IMaze;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;

public interface IMazeService {

	IMaze getMaze();

	Set<Block> solveMaze(SolutionAlgorithms algorithm);

	SolutionAlgorithms[] getAvailableAlgorithms();

}

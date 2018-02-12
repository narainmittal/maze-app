package com.nmittal.mazeapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.maze.Block;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
public class MazeSolutionController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(value = "/solution-algorithms", method = RequestMethod.GET)
	public SolutionAlgorithms[] getSolutionAlgorithms() {
		return mazeService.getAvailableAlgorithms();

	}

	@RequestMapping(value = "/solve/{algorithm}", method = RequestMethod.GET)
	public Set<Block> solveMaze(@PathVariable(name = "algorithm", required = true) String algorithm) {
		return mazeService.solveMaze(SolutionAlgorithms.valueOf(algorithm));

	}
}

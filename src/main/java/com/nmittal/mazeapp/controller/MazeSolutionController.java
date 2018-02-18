package com.nmittal.mazeapp.controller;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.maze.Block;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
@RequestMapping("/maze-solution")
public class MazeSolutionController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(value = "/algorithms", method = RequestMethod.GET)
	public SolutionAlgorithms[] getSolutionAlgorithms() {
		return mazeService.getAvailableAlgorithms();

	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<Block> solveMaze(@RequestParam(name = "algorithm", required = true) String algorithm) {
		validate(algorithm);
		return mazeService.solveMaze(SolutionAlgorithms.valueOf(algorithm));

	}

	void validate(String algorithm) {
		for (SolutionAlgorithms al : SolutionAlgorithms.values()) {
			if (Objects.equals(algorithm, al.toString())) {
				return;
			}
		}
		throw new MazeException("Invalid value for algorithm");
	}
}

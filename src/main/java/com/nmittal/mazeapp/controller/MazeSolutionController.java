package com.nmittal.mazeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
public class MazeSolutionController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(value = "/solutions", method = RequestMethod.GET)
	public SolutionAlgorithms[] getSolutionAlgorithms() {
		return mazeService.getAvailableAlgorithms();

	}
}

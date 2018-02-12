package com.nmittal.mazeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.maze.IMaze;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
public class MazeController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(value = "/maze", method = RequestMethod.GET)
	public IMaze getMazeDefinition() {
		IMaze maze = mazeService.getMaze();
		return maze;
	}
}

package com.nmittal.mazeapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nmittal.mazeapp.domain.SolutionAlgorithms;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MazeServiceTest {

	@Autowired
	private IMazeService mazeService;

	@Test
	public void testService() {
		assertThat(mazeService).isNotNull();
	}

	@Test
	public void testAlgorithmList() {
		assertThat(mazeService.getAvailableAlgorithms()).containsExactly(SolutionAlgorithms.values());
	}

	@Test
	public void testGetMaze() {
		assertThat(mazeService.getMaze()).isNotNull().hasNoNullFieldsOrProperties();
	}

}

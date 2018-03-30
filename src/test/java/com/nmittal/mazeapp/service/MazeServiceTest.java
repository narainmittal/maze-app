package com.nmittal.mazeapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Matchers.anyLong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nmittal.maze.util.MazeBuilder;
import com.nmittal.mazeapp.dao.IMazeDao;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class MazeServiceTest {

	@Autowired
	private IMazeService mazeService;

	@MockBean
	private IMazeDao mazeDao;

	@Test
	public void testService() {
		assertThat(mazeService).isNotNull();
	}

	@Test
	public void testAlgorithmList() {
		assertThat(mazeService.getAvailableAlgorithms()).containsExactly(SolutionAlgorithms.values());
	}

	@Test
	public void testGetMazeFailure() {
		BDDMockito.given(mazeDao.getMaze(anyLong())).willReturn(null);

		assertThatThrownBy(() -> mazeService.getMaze(0)).isInstanceOf(MazeException.class)
				.hasMessageContaining("not found");
	}

	@Test
	public void testGetMaze() {
		BDDMockito.given(mazeDao.getMaze(anyLong()))
				.willReturn(MazeBuilder.buildMaze(new int[][] { { 1 } }, 0, 0, 0, 0));

		assertThat(mazeService.getMaze(0)).isNotNull().hasFieldOrProperty("blocks").hasFieldOrProperty("start")
				.hasFieldOrProperty("end");
	}

}

package com.nmittal.mazeapp.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class LocalMazeDaoTest {

	@TestConfiguration
	class LocalMazeConfiguration {
		@Bean
		public IMazeDao mazeDao() {
			return new LocalMazeDao();
		}
	}

	@Autowired
	private IMazeDao mazeDao;

	@Test
	public void testCreate() {
		assertThat(mazeDao.createMaze()).isNotNull().hasFieldOrProperty("blocks").hasFieldOrProperty("start")
				.hasFieldOrProperty("end");

	}

	@Test
	public void testGet() {
		assertThat(mazeDao.getMaze(0)).isNotNull().hasFieldOrProperty("blocks").hasFieldOrProperty("start")
				.hasFieldOrProperty("end");

	}

}

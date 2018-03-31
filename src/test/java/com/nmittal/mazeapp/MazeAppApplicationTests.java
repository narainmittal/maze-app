package com.nmittal.mazeapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.nmittal.mazeapp.domain.MazeGrid;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MazeAppApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Test
	public void testMazeGet() {
		Map<String, Object> maze = restTemplate.getForObject("/maze/0", Map.class);
		assertThat(maze).containsKeys("blocks", "start", "end");
	}

	@Test
	public void testMazeAlgorithmList() throws JSONException {
		String obj = restTemplate.getForObject("/maze-solution/algorithms", String.class);
		String expected = "[\"DFS\",\"BFS\"]";
		assertThat(obj).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	public void testMazeSolveWithoutAlgorithm() {
		ResponseEntity<String> response = restTemplate.getForEntity("/maze-solution/0/solve", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testMazeSolveWithInvalidAlgorithm() {
		ResponseEntity<String> response = restTemplate.getForEntity("/maze-solution/0/solve?algorithm=ABC",
				String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testMazeSolveWithAlgorithm() {
		ResponseEntity<String> response = restTemplate.getForEntity("/maze-solution/0/solve?algorithm=DFS",
				String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	public void testCreateMaze() {
		ResponseEntity<String> response = restTemplate.postForEntity("/maze", new MazeGrid(6, 6), String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotEmpty();
	}

}

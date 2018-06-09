package com.nmittal.maze.util;

import java.util.Objects;

import com.nmittal.maze.domain.Aisle;
import com.nmittal.maze.domain.Block;
import com.nmittal.maze.domain.Maze;
import com.nmittal.maze.domain.Wall;

public class MazeBuilder {

	public static Maze buildMaze(int[][] data, int startX, int startY, int finishX, int finishY) {
		Objects.requireNonNull(data);

		int rows = data.length;
		int columns = data[0].length;
		try {
			Block[][] blocks = new Block[rows][columns];
			for (int i = 0; i < rows; i++) {
				if (data[i].length != columns) {
					throw new IllegalArgumentException("Invalid data");
				}
				for (int j = 0; j < columns; j++) {
					if (data[i][j] == 0) {
						blocks[i][j] = new Aisle(i, j);
					} else if (data[i][j] == 1) {
						blocks[i][j] = new Wall(i, j);
					} else {
						throw new IllegalArgumentException("Invalid data");
					}
				}
			}

			Block start = blocks[startX][startY];
			Block end = blocks[finishX][finishY];

			Maze maze = new Maze(blocks, start, end);
			return maze;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Invalid data");
		}
	}
}

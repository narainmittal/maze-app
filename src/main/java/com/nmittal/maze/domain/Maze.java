package com.nmittal.maze.domain;

import java.util.Arrays;

import com.nmittal.maze.solve.IMazeSolver;

/**
 * Maze data structure. Consists of 2D array of blocks, a starting block and end
 * block.
 * 
 * @author Narain Mittal
 * 
 */
public class Maze implements IMaze {

	private final Block[][] blocks;

	private final Block start;

	private final Block end;

	public Maze(Block[][] blocks, Block start, Block end) {
		this.blocks = blocks;
		this.start = start;
		this.end = end;
	}

	@Override
	public Block getStart() {
		return start;
	}

	@Override
	public Block getEnd() {
		return end;
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	@Override
	public String display(IMazeSolver solver) {
		StringBuilder builder = new StringBuilder();
		Arrays.stream(blocks).forEach(row -> {
			Arrays.stream(row).forEach(col -> builder.append(col.display(solver)));
			builder.append("\n");
		});
		return builder.toString();
	}

	@Override
	public Block getBlock(int x, int y) {
		return blocks[x][y];
	}
}

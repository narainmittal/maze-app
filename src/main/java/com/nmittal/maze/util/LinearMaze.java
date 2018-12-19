package com.nmittal.maze.util;

import java.util.Random;

/**
 * @author Narain Mittal
 *
 */
public final class LinearMaze {
	private final int[] maze;
	private final int[] size;
	private final int[] block;
	private final int rows;
	private final int cols;
	private final int start;
	private final int end;
	private final Random randomGenerator = new Random();
	private static final int AISLE = 1;

	LinearMaze(int r, int c, int s, int e) {
		rows = r;
		cols = c;
		start = s;
		end = e;

		final int blocks = rows * cols;

		maze = new int[blocks];
		size = new int[blocks];
		block = new int[blocks];

		// block[start] = AISLE;
		// block[end] = AISLE;

		for (int i = 0; i < blocks; i++) {
			maze[i] = i;
		}
	}

	public void build() {
		open(start);
		open(end);
		while (!connected(start, end)) {
			int random = randomGenerator.nextInt(maze.length);
			open(random);
		}
	}

	public void open(int dex) {
		if (block[dex] != AISLE) {
			// System.out.println(String.format("Open: %s", dex));
			// flip the status
			block[dex] = AISLE;

			// connected neighbors

			// left
			if (dex % cols > 0) {
				join(dex - 1, dex);
			}
			// right
			if ((dex + 1) % cols > 0) {
				join(dex, dex + 1);
			}
			// top
			join(dex - cols, dex);
			// bottom
			join(dex, dex + cols);
		} else {
			// System.out.println(String.format("Already open: %s", dex));
		}

	}

	public int root(int p) {
		while (maze[p] != p) {
			// Flattening
			maze[p] = maze[maze[p]];
			p = maze[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {

		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}

	public void join(int p, int q) {
		// System.out.println(String.format("Join: %s, %s", p, q));

		if (Boolean.logicalAnd(p >= 0 && p < maze.length && block[p] == AISLE,
				q >= 0 && q < maze.length && block[q] == AISLE)) {
			int proot = root(p);
			int qroot = root(q);
			if (size[qroot] <= size[proot]) {
				maze[qroot] = proot;
				size[proot]++;
				// System.out.println(String.format("Unionp(%s,%s): updated %s to %s", p, q,
				// qroot, proot));
			} else {
				maze[proot] = qroot;
				size[qroot]++;
				// System.out.println(String.format("Unionq(%s,%s): updated %s to %s", p, q,
				// proot, qroot));
			}
		}
	}

	public void display() {
		System.out.println("=========================================");
		for (int i = 0; i < maze.length; i++) {
			System.out.print(block[i] == AISLE ? "-" : "*");
			if ((i + 1) % cols == 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		LinearMaze maze = new LinearMaze(3, 5, 0, 14);
		maze.build();
		maze.display();
	}

}

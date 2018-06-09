package com.nmittal.maze.solve;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.nmittal.maze.domain.Aisle;
import com.nmittal.maze.domain.Block;
import com.nmittal.maze.domain.IMaze;

/**
 * Applies the DFS algirithm to solve the Maze. Uses stack data structure to
 * keep a track of visited blocks. Traverses the aisles recursively until
 * reaches finish/ doesn't find a path to finish
 *
 * @author Narain Mittal
 */
public class MazeSolverDfs implements IMazeSolver {

	private IMaze maze;

	private final Deque<Block> stack = new ArrayDeque<>();

	private final Set<Block> visitedBlocks = new HashSet<>();

	private final Set<Block> solutionBlocks = new HashSet<>();

	public MazeSolverDfs(IMaze maze) {
		this.maze = Objects.requireNonNull(maze);
	}

	@Override
	public boolean solve() {
		this.visitedBlocks.add(maze.getStart());
		this.solutionBlocks.add(maze.getStart());
		this.stack.push(maze.getStart());
		return solveDfs();
	}

	@Override
	public long solutionPathSize() {
		return this.solutionBlocks.size();
	}

	public Block getNextTraversalAisle(Block block) {
		int x = block.getX();
		int y = block.getY();
		Block next = null;
		if (isValidAisle(x + 1, y)) {
			next = maze.getBlock(x + 1, y);
		} else if (isValidAisle(x, y + 1)) {
			next = maze.getBlock(x, y + 1);
		} else if (isValidAisle(x, y - 1)) {
			next = maze.getBlock(x, y - 1);
		} else if (isValidAisle(x - 1, y)) {
			next = maze.getBlock(x - 1, y);
		}
		return next;
	}

	/**
	 * Checks if the block at designated indices is an Aisle which is not visited
	 * yet.
	 *
	 * @param x
	 * @param y
	 * @return true if valid, false otherwise
	 */
	private boolean isValidAisle(int x, int y) {
		try {
			Block b = maze.getBlock(x, y);
			return (b instanceof Aisle) && !isBlockVisited(b);
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}

	private boolean solveDfs() {
		Optional<Block> block = Optional.ofNullable(stack.peekFirst());

		while (block.isPresent()) {

			if (block.get().equals(maze.getEnd())) {
				// reached finish, exit the program
				return true;
			} else {
				Optional<Block> next = block.map(this::getNextTraversalAisle);
				if (next.isPresent()) {
					// Traverse next block
					traverseNextBlock(next.get());
				} else {
					// Dead end, backtrack and chose alternate path
					this.solutionBlocks.remove(stack.pop());
				}
			}

			block = Optional.ofNullable(stack.peekFirst());
		}
		// stack empty and not reached the finish yet; no solution
		this.solutionBlocks.clear();
		return false;
	}

	private void traverseNextBlock(Block next) {
		this.solutionBlocks.add(next);
		this.visitedBlocks.add(next);
		stack.push(next);
	}

	@Override
	public boolean isBlockInSolution(Block block) {
		return solutionBlocks.contains(block);
	}

	@Override
	public boolean isBlockVisited(Block block) {
		return visitedBlocks.contains(block);
	}

	@Override
	public Set<Block> getSolutionPath() {
		return solutionBlocks;
	}

}

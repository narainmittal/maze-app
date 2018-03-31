package com.nmittal.mazeapp.domain;

public class MazeGrid {

	private int rows;

	private int cols;

	public MazeGrid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MazeGrid(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

}

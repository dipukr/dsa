import java.awt.*;
import javax.swing.*;

public class Maze extends JPanel {

	private static final Color wallColor = new Color(39,40,34);
	private static final int gridSize = 50;
	private static final int margin = 100;
	
	private int[][] maze;
	private int row;
	private int col;
	
	public Maze(int[][] maze) {
		this.maze = maze;
		this.row = maze.length;
		this.col = maze[0].length;
		int W = gridSize * col;
		int H = gridSize * row;
		setVisible(true);
		setPreferredSize(new Dimension(W+margin, H+margin));
	}

	public boolean isValid(int r, int c) {
		if (r >= 0 && r < row && c >= 0 && c < col)
			return maze[r][c] == 1;
		return false;
	}

	public boolean hasPath(int r, int c) {
		if (isValid(r, c)) {
			if (r == row-1 && c == col-1)
				return true;
			maze[r][c] = 2;
			if (hasPath(r, c - 1)) return true;
			if (hasPath(r, c + 1)) return true;
			if (hasPath(r - 1, c)) return true;
			if (hasPath(r + 1, c)) return true;
			maze[r][c] = 1;
		}
		return false;
	}

	public int rowCount() {return row;}
	public int colCount() {return col;}
	
	public String toString() {
		var buf = new StringBuffer();
		for (int i = 0; i < row; i++) {
			buf.append('[');
			for (int j = 0; j < col; j++) {
				if (maze[i][j] == 0)
					buf.append('@');
				else if (maze[i][j] == 2)
					buf.append('*');
				else buf.append(' ');
			}
			buf.append("]\n");
		}
		return buf.toString();
	}

	public void paint(Graphics g) {
		var gc = (Graphics2D) g;
		for (int i = 0; i < col; i++)
			for (int j = 0; j < row; j++) {
				if (maze[j][i] == 0) {
					gc.setColor(wallColor);
					gc.fillRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
				} else if (maze[j][i] == 2) {
					gc.setColor(Color.red);
					gc.fillRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
				}
				gc.setColor(Color.black);
				gc.drawRect(i*gridSize+margin/2, j*gridSize+margin/2, gridSize, gridSize);
			}
	}

	public static void main(String[] args) throws Exception {
		int data[][] = {
			{1,1,0,1,0,0,0,0,0,0},
			{0,1,0,1,1,1,1,1,1,1},
			{0,1,0,0,0,0,0,1,0,1},
			{0,1,1,1,1,1,0,1,1,0},
			{0,0,0,0,0,1,0,1,1,1},
			{1,1,1,1,1,1,0,0,0,0},
			{1,1,1,0,1,1,1,1,1,0},
			{1,0,0,0,0,0,0,1,1,0},
			{1,1,1,1,1,1,0,0,0,0},
			{0,0,0,0,0,1,1,1,1,1}
		};
		int data2[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0},
			{0,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,0},
			{0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0},
			{0,1,0,1,0,0,0,1,0,1,1,1,1,0,1,1,0},
			{0,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,0},
			{0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		var frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		var maze = new Maze(data);
		maze.hasPath(0,0); // (2,9)
		frame.add(maze, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}
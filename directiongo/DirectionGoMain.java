package com.training.exam.directiongo;

public class DirectionGoMain {

	public static String[][] maps = new String[][] {
		{"A", "B", "C", "D"},
		{"E", "F", "G", "H"},
		{"I", "J", "K", "L"},
		{"M", "N", "O", "P"},
	};
	
//	public static String direction =  "→←↑↓↘︎↗︎↖︎↙︎";
	
	public static String direction =  "←←←←←←←←←→→↗↘↓";
	
	public static void main(String[] args) {
		Position position = new Position(2, 1);

		System.out.println(maps[position.row][position.column]);
		
		// 分隔字串，取得個別的char，再判斷方向
		char[] nextDirections = direction.toCharArray();
		
		for (char nextDirection: nextDirections) {
			switch(nextDirection) {
			case '→':
				goMap(position, 0, 1);
				break;
			case '←':
				goMap(position, 0, -1);
				break;
			case '↑':
				goMap(position, -1, 0);
				break;
			case '↓':
				goMap(position, 1, 0);
				break;
			case '↘':
				goMap(position, 1, 1);
				break;
			case '↗':
				goMap(position, -1, 1);
				break;
			case '↖':
				goMap(position, -1, -1);
				break;
			case '↙':
				goMap(position, 1, -1);
				break;
			}
		}
	}
	
	/**
	 * 判斷下一個位置是否合法，如果合法則將當前位置用下一位置替換
	 * @param position 當前位置
	 * @param rowGo row移動的方向
	 * @param columnGo column移動的方向
	 */
	public static void goMap(Position position, int rowGo, int columnGo) {
		int nextRow = position.row + rowGo;
		int nextColumn = position.column + columnGo;
		// 檢查是否超過地圖邊界
		if (maps.length > nextRow && nextRow >=0) {
			if (maps[nextRow].length > nextColumn && nextColumn >= 0) {
				// 能夠合法動，將位置調整
				position.row = nextRow;
				position.column = nextColumn;
			}
		}
		// 如果不合法，則位置維持不變
		System.out.println(maps[position.row][position.column]);
	}
}

class Position {
	int row;
	int column;
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
}

package com.training.exam.mirror;

public class MirrorWorld {

	public static void main(String[] args) {
		String[][] mirror = new String[][] {
			{"Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
			{"Ｏ", "Ｏ", "Ｘ", "Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
			{"Ｏ", "Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
			{"Ｏ", "Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
			{"Ｏ", "Ｏ", "Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
			{"Ｏ", "Ｏ", "Ｏ", "Ｘ", "Ｏ", "Ｏ", "Ｏ", "Ｏ"},
		};
		
		int mirrorColumnLength = mirror[0].length;
		// 取得鏡子的ㄧ半長度，代表鏡射的中間值
		int middle = mirror[0].length / 2;
		
		// loop上到下
		for (int row = 0; row < mirror.length ; row += 1) {
			// loop 左到右
			for (int column = 0 ; column < middle ; column += 1) {
				// 第1欄存到第4欄的位置(index: 8 - 1 - 0)
				// 第2欄存到第3欄的位置(index: 8 - 1 - 1)
				mirror[row][mirrorColumnLength -1 - column] = mirror[row][column];
			}
		}
		
		// 列印結果
		for (String[] row : mirror) {
			for (String column : row) {
				System.out.print(column);
			}
			System.out.println();
		}
	}

}

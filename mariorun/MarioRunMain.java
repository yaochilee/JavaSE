package com.training.exam.mariorun;

public class MarioRunMain {

	public static void main(String[] args) {
		String[][] maps  = new String[][] {
			{"◼", "◼", "◼", "◼", "◼", "◼", "◼"},
			{"◼", "○", "◼", "◼", "◼", "◼", "○"},
			{"◼", "○", "◼", "◼", "◼", "྾", "○"},
			{"○", "○", "྾", "○", "◼", "○", "○"},
			{"○", "○", "○", "○", "○", "○", "○"},
		};
		
		// 針對每一欄從上到下檢查
		// 看到◼就忽略，看到○把位置紀錄下來，看到྾直接紀錄0
		// 加總跳耀結果
		
		// 跳耀軌跡
		int[] jumpHistory = new int[maps[0].length];
		
		// 每一欄的迴圈(從左到右)
		for (int column = 0 ; column < maps[0].length ; column += 1) {
			// 從上到下的迴圈
			for (int row = 0 ; row < maps.length; row += 1) {
				String current = maps[row][column];
//				System.out.println(current);
				
				if (current.equals("○")) {
					// 踩到地板，將所在位置紀錄，提供後續計算(紀錄從上往下的層數)
					jumpHistory[column] = maps.length - row;
					// 找到地板就跳過迴圈
					break;
				} else if (current.equals("྾")) {
					// 踩到洞，直接視為0 
					jumpHistory[column] = 0;
					// 踩到洞就跳過迴圈
					break;
				}
			}
		}
		
		int totalCount = 0;
		// 紀錄最後一個非0的高度
		int temp = 0;
		// 計算跳耀，只要後一個數字比前一個數字小，就當作0
		for (int step = 0 ; step < jumpHistory.length ; step += 1) {
			
			// 不為0才需判斷
			if (jumpHistory[step] > 0) {
				// 當前位置大於上次的紀錄的位置，計算差值並加總
				if (jumpHistory[step] - temp > 0) {
					totalCount += (jumpHistory[step] - temp);
				}
				// 紀錄最後一個非0的高度
				temp = jumpHistory[step];
			} else {
				// 陷阱直接跳過不判斷(這個else是多的)
				continue;
			}
		}
		System.out.println("跳躍次數" + totalCount);
	}

}

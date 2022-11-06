package com.training.exam.lamp;

public class LampMain {

	public static void main(String[] args) {
		Lamp lamp1 = new Lamp("綠燈", 2);
		Lamp lamp2 = new Lamp("黃燈", 4);
		Lamp lamp3 = new Lamp("紅燈", 6);

		Lamp[] lampArray = new Lamp[] {lamp1, lamp2, lamp3};
		
		int totalSecond = 120;
		
		// 先取得最小公倍數
		int leastCommonMultiple = getLeastCommonMultiple(lampArray);
		System.out.println("最小公倍數：" + leastCommonMultiple);
		
		// 最小公倍數小於總秒數才處理
		if (leastCommonMultiple < totalSecond) {
			for (int sec = leastCommonMultiple ; sec <= totalSecond ; sec += leastCommonMultiple) {
				for (Lamp lamp : lampArray) {
					// 印出燈號
					System.out.println(genDiplay(lamp, sec));
				}
				System.out.println("-------------------");
			}
		}
	}
	
	/**
	 * 組裝顯示呈現
	 * @param lamp
	 * @param sec
	 * @return
	 */
	private static String genDiplay(Lamp lamp, int sec) {
		StringBuilder sb = new StringBuilder();
		sb.append(lamp.getText()).append(" ").append(lamp.getBrightSecond()).append("*").append(sec/lamp.getBrightSecond()).append("=").append(sec);
		return sb.toString();
	}
	
	/**
	 * 取得最小公倍數
	 * @param lampArray
	 * @return
	 */
	private static int getLeastCommonMultiple(Lamp[] lampArray) {
		// 最大輸入數值
		int maxNumber = 0;
		int maxMultipleNumber = 1;
		
		for (Lamp lamp : lampArray) {
			int second = lamp.getBrightSecond();
			// 取得秒數的最大值
			if (second > maxNumber) {
				maxNumber = second;
			}
			// 計算秒數相乘
			maxMultipleNumber = maxMultipleNumber * second;
		}
		
		// 窮舉法找出最小公倍數，比最大數值大，比相乘小
		for (int i = maxNumber ; i <= maxMultipleNumber ; i += 1) {
			boolean hit = false;
			for (Lamp lamp : lampArray) {
				if (i % lamp.getBrightSecond() == 0) {
					// 可以整除，就往下一個lamp判斷是否可以整除
					hit = true;
				} else {
					hit = false;
					// 不能整除，跳過lamp迴圈，直接找下一個數值
					break;
				}
			}
			// 如果迴圈跑完 hit是true就代表此數字為最小公倍數
			if (hit) {
				return i;
			}
		}
		return 0;
	}
}

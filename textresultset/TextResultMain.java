package com.training.exam.textresultset;

public class TextResultMain {

	public static void main(String[] args) {

		String[] texts = new String[] {"阿", "拉", "丁", "與", "公", "主"};

		int textLength = texts.length;
		
		for(int words = texts.length ; words > 0 ; words -= 1) {
			// 這次有幾個字
			System.out.println("" + words + "字結果:");
			
			// 這次要印幾次：字串長度-結果數量+1
			int resultCount = textLength - words + 1;
			
			for (int i = 0 ; i < resultCount ; i += 1) {
				for (int j = i ; j < words + i ; j += 1 ) {
					System.out.print(texts[j]);
				}
				System.out.println("");
			}
		}
	}

}

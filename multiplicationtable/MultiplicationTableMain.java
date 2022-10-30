package com.training.exam.multiplicationtable;

public class MultiplicationTableMain {

	public static void main(String[] args) {

		for (int i = 2 ; i <= 9 ; i += 1) {
			for (int j = 2 ; j <= 9 ; j += 1) {
				if (j < i) {
					continue;
				}
				System.out.print("" + i + "*" + j + "=" + (i*j));
				System.out.print(" ");
			}
			System.out.print("\n");
		}

	}

}

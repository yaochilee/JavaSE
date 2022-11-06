package com.training.exam.lamp;

public class Lamp {

	/** 燈的名稱 */
	private String text;
	
	/** 每幾秒亮一次 */
	private int brightSecond;

	public Lamp(String text, int brightSecond) {
		this.text = text;
		this.brightSecond = brightSecond;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getBrightSecond() {
		return brightSecond;
	}

	public void setBrightSecond(int brightSecond) {
		this.brightSecond = brightSecond;
	}
}

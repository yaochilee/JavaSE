package com.training.exam.lyricsearch;

public class LyricSearchMain {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();

		sb.append("讓我將妳心兒摘下");
		sb.append("試著將它慢慢溶化");
		sb.append("看我在妳心中是否仍完美無瑕");
		sb.append("是否依然為我絲絲牽掛");
		sb.append("依然愛我無法自拔");
		sb.append("心中是否有我未曾到過的地方啊");
		sb.append("那裡湖面總是澄清");
		sb.append("那裡空氣充滿寧靜");
		sb.append("雪白明月照在大地");
		sb.append("藏著妳不願提起的回憶");
		sb.append("妳說真心總是可以從頭");
		sb.append("真愛總是可以長久");
		sb.append("為何妳的眼神還有孤獨時的落寞");
		sb.append("是否我只是妳一種寄託");
		sb.append("填滿妳感情的缺口");
		sb.append("心中那片森林何時能讓我停留");
		sb.append("那裡湖面總是澄清");
		sb.append("那裡空氣充滿寧靜");
		sb.append("雪白明月照在大地");
		sb.append("藏著妳最深處的秘密");
		sb.append("或許我不該問");
		sb.append("讓妳平靜的心再起漣漪");
		sb.append("只是愛妳的心超出了界限");
		sb.append("我想擁有妳所有一切");
		sb.append("應該是我不該問");
		sb.append("不該讓妳再將往事重提");
		sb.append("只是心中枷鎖");
		sb.append("該如何才能解脫");
		sb.append("讓我將妳心兒摘下");
		sb.append("試著將它慢慢溶化");
		sb.append("看我在妳心中是否仍完美無瑕");
		sb.append("是否依然為我絲絲牽掛");
		sb.append("依然愛我無法自拔");
		sb.append("心中是否有我未曾到過的地方啊");
		sb.append("那裡湖面總是澄清");
		sb.append("那裡空氣充滿寧靜");
		sb.append("雪白明月照在大地");
		sb.append("藏著妳最深處的秘密");
		sb.append("或許我不該問");
		sb.append("讓妳平靜的心再起漣漪");
		sb.append("只是愛妳的心超出了界限");
		sb.append("我想擁有妳所有一切");
		sb.append("應該是我不該問");
		sb.append("不該讓妳再將往事重提");
		sb.append("只是心中枷鎖");
		sb.append("該如何才能解脫");
		sb.append("或許我不該問");
		sb.append("讓妳平靜的心再起漣漪");
		sb.append("只是愛妳的心超出了界限");
		sb.append("我想擁有妳所有一切");
		sb.append("應該是我不該問");
		sb.append("不該讓妳再將往事重提");
		sb.append("只是心中枷鎖");
		sb.append("該如何才能解脫");
		
		String[] searchKeyword = new String[] {
				"那裡", "心中", "喔喔喔喔喔喔ㄛ", "解脫"
		};

		int[] counts = new int[searchKeyword.length];
		// 搜尋字詞
		for (int i = 0; i < searchKeyword.length ; i += 1) {
			String lyricAfterSubString = sb.toString();
			int index = 0;
			do {
				index = lyricAfterSubString.indexOf(searchKeyword[i]);
				if (index > 0 ) {
					// 有命中則將計數加1
					counts[i] += 1;
					
					// 將命中的關鍵字從歌詞當中移除
					lyricAfterSubString = lyricAfterSubString.substring(index + searchKeyword[i].length());
				}
			} while (index > 0);	
		}
		for (int count : counts) {
			System.out.println("數量：" + count);
		}

		System.out.println("--------------------------");
		for (int i = 0; i < searchKeyword.length ; i += 1) {
			// 最後補空白是針對關鍵字在最後面的特殊處理
			String allLyric = sb.append(" ").toString();
			
			// 把關鍵字當分割字串
			String[] splitArray = allLyric.split(searchKeyword[i]);
			// 分割後的字串數量-1即為命中的數量
			counts[i] = splitArray.length - 1;
		}
		
		for (int count : counts) {
			System.out.println("數量：" + count);
		}
	}
}

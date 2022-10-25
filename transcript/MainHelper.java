package com.training.exam.transcript;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainHelper {

	/**
	 * 讀檔
	 * 
	 * @param filePath
	 * @param titleList
	 * @param students
	 */
	public void loadFile(String filePath, List<String> titleList, List<Student> students) {
		// try with recourse 
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath)); BufferedReader reader = new BufferedReader(isr);) {

			Integer lineIndex = 0;
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				
				if (lineIndex == 0) {
					// 第一行為Title
					titleList.addAll(Arrays.asList(data));
				} else {
					// 學生資料
					Student student = new Student();
					// 序號
					student.setSeq(Integer.parseInt(data[0]));
					// 姓名
					student.setName(data[1]);
					// 各項成績
					List<Examination> examList = new ArrayList<>();
					// 總分
					Integer total = 0;
					
					// 針對每個科目取得分數，並計算總分跟平均
					for(int i = 2; i < data.length; i += 1) {
						Examination exam = new Examination();
						Integer score = Integer.parseInt(data[i]);
						exam.setScore(score);
						// 總分加總
						total += score;
						examList.add(exam);
					}
					student.setExams(examList);
					student.setTotalScore(total);
					Integer examCount = data.length - 2;
					// 計算平均
					BigDecimal avarage = new BigDecimal("0");
					avarage = new BigDecimal(String.valueOf(total)).divide(new BigDecimal(String.valueOf(examCount)), 2,  RoundingMode.HALF_UP);
					student.setAvarage(avarage);
					students.add(student);
				}
				lineIndex += 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * 寫檔
	 * @param writePath
	 * @param titleList
	 * @param students
	 */
	public void writeFile(String writePath, List<String> titleList, List<Student> students) {
	    File csvOutputFile = new File(writePath);
	    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
	    	pw.println(genOuputTitle(titleList));
	    	students.stream()
	          .map(this::convertToCSV)
	          .forEach(pw::println);
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 標題列轉成CSV格式，用逗號分隔
	 * @param titleList
	 * @return
	 */
	private String genOuputTitle(List<String> titleList) {
		titleList.add("總分");
		titleList.add("平均");
		titleList.add("名次");
		return titleList.stream().collect(Collectors.joining(","));
	}
	/**
	 * 學生資料轉成CSV格式，用逗號分隔
	 * @param student
	 * @return
	 */
	private String convertToCSV(Student student) {
		List<String> csvLine = new ArrayList<>();
		csvLine.add(String.valueOf(student.getSeq()));
		csvLine.add(student.getName());
		for (Examination exam : student.getExams()) {
			csvLine.add(String.valueOf(exam.getScore()));
		}
		csvLine.add(String.valueOf(student.getTotalScore()));
		csvLine.add(student.getAvarage().toString());
		csvLine.add(String.valueOf(student.getRank()));
		return csvLine.stream().collect(Collectors.joining(","));
	}

}

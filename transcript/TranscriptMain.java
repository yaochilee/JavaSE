package com.training.exam.transcript;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TranscriptMain {

	public static void main(String[] args) {

		MainHelper helper = new MainHelper();
		
		String filePath = "/Users/guybrush/Desktop/JavaSE/StudentsScoreData.csv";
		
		List<String> titleList = new ArrayList<>();
		
		List<Student> students = new ArrayList<>();
		// 讀檔
		helper.loadFile(filePath, titleList, students);
		
		// 先針對總分排序，如果同分比國文	
		students = students.stream().sorted(Comparator.comparing(Student::getTotalScore)
				.thenComparing((o1, o2)->o1.getExams().get(0).getScore().
                        compareTo(o2.getExams().get(0).getScore()))
				.reversed())
			.collect(Collectors.toCollection(ArrayList::new));
		
		// 加入排名
		AtomicInteger x = new AtomicInteger(1);
		students.stream().forEach(s -> s.setRank(x.getAndIncrement()));

		// 寫檔
		String writePath = "/Users/guybrush/Desktop/JavaSE/StudentsScoreResultData.csv";
		helper.writeFile(writePath, titleList, students);
	}

}

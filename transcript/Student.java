package com.training.exam.transcript;

import java.math.BigDecimal;
import java.util.List;

public class Student {
	/** 序號 */
	private Integer seq;
	
	/** 姓名 */
	private String name;
	
	/** 考試分數列表 */
	private List<Examination> exams;
	
	/** 總分 */
	private Integer totalScore;
	
	/** 平均分數 */
	private BigDecimal avarage;
	
	/** 排名 */
	private Integer rank;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Examination> getExams() {
		return exams;
	}

	public void setExams(List<Examination> exams) {
		this.exams = exams;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public BigDecimal getAvarage() {
		return avarage;
	}

	public void setAvarage(BigDecimal avarage) {
		this.avarage = avarage;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}

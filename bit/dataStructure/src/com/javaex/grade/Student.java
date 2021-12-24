package com.javaex.grade;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int memberId;
	private double avg;

	Student(String name, int kor, int eng, int mat, int memberId) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.avg = (double)(kor+eng+mat)/3;
		this.memberId=memberId;
	}
	
	public Student() {
		
	}
	
	
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int score() {
		return (kor + eng + mat);
	}
	
	public double getAvg() {
		return (kor+eng+mat)/3;
	}
	
	@Override
	public String toString() {
		return "이름=" + name + ",  국어성적=" + kor + ", 영어성적=" + eng + ", 수학성적=" + mat + ", 평균=" + getAvg();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}
	
	
	
	
}

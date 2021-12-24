package com.javaex.api.objectclass.v4;

import java.util.Arrays;

public class Scoreboard implements Cloneable {
	// 참조 타입 필드
	private int[] scores;

	// 생성자
	public Scoreboard(int[] scores) {
		this.scores = scores; // 내부 인스턴스에 참조를 해준다
	}

	public Scoreboard getClone() {
		Scoreboard clone = null;

		try {
			clone = (Scoreboard) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 1. 얕은 복제를 시도
		Scoreboard clone = (Scoreboard) super.clone();
		// 2. 내부 참조 객체를 복제
		//scores배열을 scores배열의 길이만큼 복사
		clone.scores = Arrays.copyOf(scores, scores.length);
		return clone;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Scoreboard [scores=" + Arrays.toString(scores) + "]";
	}

}

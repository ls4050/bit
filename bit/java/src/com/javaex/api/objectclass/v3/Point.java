package com.javaex.api.objectclass.v3;

// v3. 얕은 복제
// 객체의 필드데이터를 단순 복제
// Cloneable 인터페이스 구현
public class Point implements Cloneable {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// 객체 문자열 포맷을 반환
		return String.format("Point(%d, %d)", x, y);
	}

	public Point getClone() {
		// 복제본
		Point clone = null;
		try {
			clone = (Point)clone(); // DownCasting
		} catch (CloneNotSupportedException e) {
			// 복제 실패
			e.printStackTrace();
		}

		return clone;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) { // 받아온 객체가 Point 객체라면
			// 변환
			Point other = (Point) obj;
			// 내가 가진 x 와 other가 가진 x
			// 내가 가진 y 와 other가 가진 y
			// 비교
			return x == other.x && y == other.y;
		}
		return super.equals(obj);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

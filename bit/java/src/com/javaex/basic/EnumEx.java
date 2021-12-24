package com.javaex.basic;

public class EnumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		enumEx1();
//		enumEx2("SUN");
		enumEx3(Week.FRI);
	}
	
	private static void enumEx3(Week day) {
		String message;
		
		switch (day) {
		case MON:
		case TUE:
		case WED:
		case THU:
			message = "열공";
			break;
		case FRI:
			message = "열공 후 불금";
			break;
		case SAT:
		case SUN:
			message = "주말";
			break;
		default:
			message = "?";
		}
		System.out.printf("%s에는 %s%n", day.name(), message);

	}
	
	private static void enumEx1() {
		Week today = Week.FRI;
		System.out.printf("Today is %s(%d)%n", today.name(), today.ordinal()); // ordinal : enum에서 몇번째인지
	}

	private static void enumEx2(String day) {
		// 문자열을 열거 상수를 반환
		Week obj = Week.valueOf(day);
		System.out.printf("%s is %s(%d)%n", 
				day, // 문자열
				obj.name(), // 열거상수
				obj.ordinal()); // ordinal : enum에서 몇번째인지
		Week today = Week.FRI;
		System.out.println("FRI SUN의 순번차:" + today.compareTo(obj)); // 5
	}
}

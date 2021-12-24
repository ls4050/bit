package com.javaex.basic;

public class Types {
	public static void main(String[] args) {
//		intLongEx();
//		floatDoubleEx();
//		charEx();
//		booleanEx();
//		promotionEx();
		castingEx();
	}

	// 형변환(Casting)
	private static void castingEx() {
		// 표현 범위 넓은 자료 -> 표현 범위 좁은 자료
		// 명시적으로 변환 해줘야
		float f = 123.456f;
		System.out.println(f);

		int i = (int) f;
		System.out.println(i);

		int i2 = 1234567890;
		System.out.println(Integer.toBinaryString(i2));

		short s = (short) i2;
		System.out.println(Integer.toBinaryString(s));

		// 형 변환시 자료 유실이 일어날 수 있으므로 주의
	}

	// 형변환(Promotion)
	private static void promotionEx() {
		// 표현 범위 좁은 자료 -> 표현 범위 넓은 자료
		// 자동으로 변환
		byte b = 25; // 1바이트 정수
		System.out.println(b);

		short s = b; // 2바이트 정수
		System.out.println(s);

		int i = s; // 4바이트 정수
		System.out.println(i);

		float f = i; // 4바이트 실수
		System.out.println(f);
	}

	// 논리형 타입: 참 or 거짓
	private static void booleanEx() {
		boolean b1 = true; // 참
		boolean b2 = false; // 거짓
		System.out.println(b1);
		System.out.println(b2);

		boolean result;

		int var1 = 3;
		int var2 = 5;

		result = var1 < var2; // 비교연산 or 논리연산 결과
		System.out.println(var1 + "<" + var2 + "=" + result);
	}

	// 문자형 타입: 부호 없는 정수(코드)
	private static void charEx() {
		char ch1 = 'A';
		char ch2 = '한';

		System.out.println(ch1);
		System.out.println(ch2);

		// ch1 4글자 뒤
		System.out.println(ch1 + 4);
	}

	// 실수형 타입
	private static void floatDoubleEx() {
		// float(4) < double(8:default)
		float floatVar = 3.14159F; // F or f
		double doubleVar = 3.14159;

		floatVar = 0.1234567890123456789F;
		doubleVar = 0.1234567890123456789;

		System.out.println("float:" + floatVar);
		System.out.println("double:" + doubleVar);
		// 정밀도 포기, 표현 범위 넓힌 것
		System.out.println(0.1 * 3);

		// 지수 표기법(e)
		floatVar = 3E-6F; // 3 * 10 ^ -6
		System.out.println(floatVar);
	}

	// 정수형 타입
	public static void intLongEx() {
		// byte(1) < short(2) < int(4:default) < long(8)
		int intVar1; // 선언
		int intVar2; // 선언

		intVar1 = 2021; // 초기화
		// intVar2 = 12345678901234; // 범위 초과

		System.out.println(intVar1); // 조회

		long longVar1 = 2021; // 선언 + 초기화
		long longVar2 = 12345678901234L; // L(or l) 필수

		// 2진수, 8진수, 16진수
		int bin, oct, hex;
		bin = 0b1101; // 2진수 0b
		oct = 072; // 8진수 0
		hex = 0xFF; // 16진수 0x

		System.out.println(bin);
		System.out.println(oct);
		System.out.println(hex);
	}
}

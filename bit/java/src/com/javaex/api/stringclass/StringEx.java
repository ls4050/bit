package com.javaex.api.stringclass;

public class StringEx {

	public static void main(String[] args) {
//		usefulMethods();
		stringBufferEx();
	}
	
	
	private static void stringBufferEx() {
		// 버퍼의 생성
		// 인덱스로 새는 거 아님 그냥 1부터 시작
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		// 문자열 추가 : append
		sb.append(" is pencil");
		System.out.println(sb);
		//문자열 삽입 : insert
		sb.insert(7, " my");
		System.out.println(sb);
		// 문자열 치환 : replace
		sb.replace(7, 10, " your");
		System.out.println(sb);
		// 버퍼 사이즈 조정 : setLength
		sb.setLength(5);
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("This").append(" is pencil").insert(7, " my").replace(7, 10, " your");
		String s = sb2.toString(); // 최종 문자열 생성
		System.out.println(s);
		System.out.println(sb2);
	}
	
	private static void usefulMethods() {
		// 유용한 메서드를
		String str = "Java Programming JavaScript Programming";

		System.out.println("str:" + str);
		System.out.println("LENGTH : " + str.length());

		// 변환 메서드
		System.out.println("UPPER: " + str.toUpperCase());
		System.out.println("LOWER: " + str.toLowerCase());

		// 검색 메서드
		System.out.println("인덱스 5의 글자: " + str.charAt(5));
		int index = str.indexOf("Java"); // Java의 인덱스
		System.out.println("1번째 Java 인덱스:" + index);
		index = str.indexOf("Java", 5); // 5번 인덱스 이후의 Java
		System.out.println("2번째 Java 인덱스:" + index);
		index = str.indexOf("Java", 21); // 21번 인덱스 이후의 Java
		System.out.println("3번째 Java 인덱스:" + index); // -1 : 찾을 수 없는 검색

		System.out.println("마지막 Java 인덱스:" + str.lastIndexOf("Java")); // 뒤에서부터 검색

		// 문자열 추출
		System.out.println("substring(5):" + str.substring(5)); // 5번 인덱스부터 끝까지
		System.out.println("substring(5,16):" + str.substring(5, 16)); // 5번부터 16번앞까지(15번까지)

		// 문자열 변경
		System.out.println("replace: " + str.replace("Programming", "Coding"));

		// 문자열은 변경되지 않음
		System.out.println("str:" + str);

		// 화이트 스페이스 제거 (공백, 개행, 탭)
		String s2 = "             Hello         ";
		String s3 = "         Java            ";
		System.out.println(s2.trim() + " " + s3.trim());

		// 문자열 분리
		String[] words = str.split(" "); // "" 사이에 구분자 들어감
		for (String word : words) {
			System.out.println("Word:" + word);
		}

		// 문자열의 비교: Unicode 비교
		// 0 : 순서가 같다
		// 음수 : "ABC" 순서가 빠르다
		// 양수 : "ABC" 순서가 늦다
		System.out.println("ABC".compareTo("ABD"));
	}

}

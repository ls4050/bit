package com.javaex.oop.tv.v1;

public class Tv {
	private int channel;
	private int volume;
	private boolean power;
	
	public Tv() { }

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	};
	
	void power( boolean on ) { //
		System.out.println("TV ON");
	}
	void channel( int channel )  {	//메소드 구현 (1~255 유지)
		
	}
	void channel( boolean up ) { //메소드 오버로딩 (1~255 유지, 1씩 증감)
		
	}
	void volume( int volume ) { //메소드 구현 ( 0 ~ 100 유지 )
		volume++;
	}
	void volume( boolean up ) { //메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
		
	}
	void status() { //메소드 구현( TV 정보 출력) 
		System.out.printf("TV가 %s");
	}
}

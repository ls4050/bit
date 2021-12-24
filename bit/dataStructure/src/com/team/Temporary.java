package com.team;

public class Temporary extends SalaryMan {

	public Temporary(String name,String pw, String phoneNum, Integer money, String department) {
		super(name, pw,phoneNum, money, department);
	}
	
	public void getInfo() {
		System.out.println("[비정규직]" + "이름 : " + this.name + ", 핸드폰 : " + this.phoneNum + ", 머니 : " + super.money + ", 비밀번호 : " + super.pw + ", 인센티브 : " + this.incentive + ", 시간 : " + this.time);
	}

}

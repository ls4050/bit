package com.team;

public class FullTime extends SalaryMan {
	public FullTime(String name, String pw, String phoneNum, Integer money, String department) {
		super(name, pw, phoneNum, money, department);
	}

	@Override
	public void getInfo() {
		System.out.println("[정규직]" + "이름 : " + this.name + ", 핸드폰 : " + this.phoneNum + ", 머니 : " + super.money + ", 비밀번호 : " + super.pw + ", 인센티브 : " + this.incentive + ", 시간 : " + this.time + ", 부서 : "+this.department);
		int sum_money = (this.money * super.time) + this.incentive;
		System.out.println("연봉 : " + sum_money);
	}

}

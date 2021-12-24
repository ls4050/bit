package com.team;

public class SalaryMan extends Company {
	protected String name;
	protected String phoneNum;
	protected String department;
	protected Integer money;
	protected Integer incentive;
	protected Integer time;

	public SalaryMan(String name, String pw, String phoneNum, Integer money, String department) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.department = department;
		this.money = money;

		this.incentive = 0;
		this.time = time;
		super.pw = pw;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public SalaryMan() {
		// TODO Auto-generated constructor stub
	}

	public String getPass() {
		return pw;
	}

	public void setPass(String pw) {
		super.pw = pw;
	}

	public Integer getIncentive() {
		return incentive;
	}

	public void setIncentive(Integer incentive) {
		this.incentive = incentive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean checklogin(String pass) {
		return false;
	}

	public void getInfo() {

	}

}

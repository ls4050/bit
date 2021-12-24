package com.team;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends Company {

	public Admin(String pw) {
		super.pw = pw;
		// TODO Auto-generated constructor stub
	}

	public String getPass() {
		return pw;
	}

	public void setPass(String pw) {
		super.pw = pw;
	}

	public boolean checkPass(String i) {
		if (i.equals(super.pw)) {
			return true;
		}

		return false;
	}
	//입력받은 id에 해당하는 value값 호출 => 해당 객체 setPass로 alter로 대체
	public void setPw(HashMap<String, SalaryMan> map, String id, String alter) {
		map.get(id).setPass(alter);
	}

	public void setName(HashMap<String, SalaryMan> map, String id, String alter) {
		map.get(id).setName(alter);
	}

	public void setDept(HashMap<String, SalaryMan> map, String id, String alter) {
		map.get(id).setDepartment(alter);
	}

	public void setPhone(HashMap<String, SalaryMan> map, String id, String alter) {
		map.get(id).setPhoneNum(alter);
	}
	
	//Admin_map을 iterator를 통해 SalaryMan불러온다
	public void searchAll(HashMap<String, SalaryMan> map) {
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			SalaryMan employee = map.get(key);
			employee.getInfo();
		}

	}

	public boolean searchOne(HashMap<String, SalaryMan> map, String name) {
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			SalaryMan employee = map.get(key);
			if (employee.getName().equals(name)) {
				employee.getInfo();
				return true;
			}
		}

		return false;
	}

	public void searchDept(HashMap<String, SalaryMan> map, String dept) {
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			SalaryMan employee = map.get(key);
			if (employee.getDepartment().equals(dept)) {
				employee.getInfo();
			}
		}

	}

	public void setAllPay(HashMap<String, SalaryMan> map, String id, Integer money, Integer incentive,
			Integer time) {
		setInsentive(map, id, incentive);
		setMoney(map, id, money);
		setTime(map, id, time);

		map.get(id).getInfo();
	}

	public void setInsentive(HashMap<String, SalaryMan> map, String id, Integer incentive) {
		map.get(id).setIncentive(incentive);
	}

	public void setMoney(HashMap<String, SalaryMan> map, String id, Integer money) {
		map.get(id).setMoney(money);
	}

	public void setTime(HashMap<String, SalaryMan> map, String id, Integer time) {
		map.get(id).setTime(time);
	}

	public boolean reviseMoney(HashMap<String, SalaryMan> map, String id) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 년차 or 시간 변경\t2. 인센티브 설정\t3. 기본급설정\t4. 돌아가기");
		Integer select = sc.nextInt();
		SalaryMan salaryman = map.get(id);

		if (salaryman != null) {
			switch (select) {
			case 1:
				System.out.print(" 수정 시킬 시간 입력 : ");
				int time = sc.nextInt();
				salaryman.setTime(time);
				break;
			case 2:
				System.out.print(" 수정 인센티브 입력 : ");
				int insen = sc.nextInt();
				salaryman.setIncentive(insen);
				break;
			case 3:
				System.out.print(" 수정 시킬 시간 입력 : ");
				int money = sc.nextInt();
				salaryman.setTime(money);
				break;
			case 4:
				break;
			}

			return true;
		} else {
			return false;
		}

	}

}

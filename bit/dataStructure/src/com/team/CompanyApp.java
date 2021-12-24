package com.team;

import java.util.HashMap;
import java.util.Scanner;


public class CompanyApp {
	HashMap<String, SalaryMan> salary_map = new HashMap<String, SalaryMan>();
	HashMap<String, Admin> admin_map = new HashMap<String, Admin>();
	Scanner sc = new Scanner(System.in);

	
	public void adminLogin() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("Pass : ");
		String pass = sc.next();
		Admin s1 = admin_map.get(id);
		if(amdinIdCheck(id,pass)) {
			while(true) {
				System.out.println("1.전체출력\t2.이름검색\t3.부서검색\t4.연봉조정\t5.개인정보수정");
				int select = sc.nextInt();
				if(select == 1) {
					s1.searchAll(salary_map);
					break;
				} else if(select == 2) {
					System.out.print("이름 입력 : ");
					String name = sc.next();
					s1.searchOne(salary_map, name);
					break;
				} else if(select == 3) {
					System.out.print("부서 검색 : ");
					String department = sc.next();
					s1.searchDept(salary_map, department);
					break;
				} else if(select == 4) {
					System.out.print("아이디 입력 : ");
					String id2 = sc.next();
					if(s1.reviseMoney(salary_map, id2)) {
						System.out.println("변경 완료");
					}else {
						System.out.println("변경 실패");
					}
					break;
				} else if(select == 5) {
					System.out.print("바꾸 실 아이디를 입력해주세요");
					String userid =sc.next();
					SalaryMan s= salary_map.get(userid);
					if(s ==null) {
						System.out.println("찾으시는 아이디가 없습니다");
					}else {
						System.out.println("1. 이름수정 2. 부서 수정  3. 패스워드 수정 4. 핸드폰수정 5.돌아가기");
						Integer getNum = sc.nextInt();
						System.out.print("변경할 이름 : ");
						String name = sc.next();
						System.out.print("변경할 부서 : ");
						String department = sc.next();
						System.out.print("변경할 비밀번호 : ");
						String newPass = sc.next();
						System.out.print("변경할 핸드폰번호 : ");
						String phoneNum = sc.next();
						s.setName(name);
						s.setDepartment(department);
						s.setPass(newPass);
						s.setPhoneNum(phoneNum);
					}
					break;
				}
			}
		}
		
	}
	
	public void userLogin() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("Pass : ");
		String pass = sc.next();
		if(userIdCheck(id, pass)) {
			while(true) {
				System.out.println("1.개인정보조회\t2.개인정보수정\t3.돌아가기");
				int select = sc.nextInt();
				if(select == 1) {
					SalaryMan s1 = salary_map.get(id);
					if(s1==null) System.out.println("찾는 아이디 없음");
					else {
						s1.getInfo();
					}
				} else if(select == 2) {
					SalaryMan s2 = salary_map.get(id);
					if(s2==null){
					 System.out.println("찾는 아이디 없음");
					}else{
						System.out.print("변경할 이름 : ");
						String name = sc.next();
						System.out.print("변경할 부서 : ");
						String department = sc.next();
						System.out.print("변경할 비밀번호 : ");
						String newPass = sc.next();
						System.out.print("변경할 핸드폰번호 : ");
						String phoneNum = sc.next();
						s2.setName(name);
						s2.setDepartment(department);
						s2.setPass(newPass);
						s2.setPhoneNum(phoneNum);
						System.out.println("변경완료");
					}
				} else if(select == 3) {
					break;
				}
			}
		} else {
			System.out.println("아이디나 비밀번호가 틀립니다.");
		}
	}
	
	public boolean userIdCheck(String id,String pw) {
		SalaryMan temp=salary_map.get(id);
		if(temp==null) {
			return false;
		}else {
			if(temp.getPass().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean amdinIdCheck(String id,String pw) {
		Admin temp=admin_map.get(id);
		if(temp==null) {
			return false;
		}else {
			if(temp.getPass().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	public void adminJoin() {
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pass = sc.next();
		admin_map.put(id, new Admin(pass));
	}
	
	public void userJoin() {
		CompanyApp app = new CompanyApp();
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pass = sc.next();
		System.out.print("핸드폰 번호 입력 : ");
		String phoneNum = sc.next();
		System.out.print("부서 입력 : ");
		String department = sc.next();
		System.out.print("연봉 입력 : ");
		Integer money = sc.nextInt();
		System.out.println("고용 형태 :  1. 정규직\t2. 비정규직");
		int i = sc.nextInt();
		switch(i) {
		case 1:
			salary_map.put(id, new FullTime(name,pass,phoneNum,money,department));
			System.out.println("가입성공");
			break;
		case 2: 
			salary_map.put(id, new Temporary(name,pass,phoneNum,money,department));
			System.out.println("가입성공");
			break;
		}
	}
	

	
	public void run() {
		while (true) {
			System.out.println("1.로그인\t2.회원가입");
			int select = sc.nextInt();
			if (select == 2) {
				System.out.println("1.User\t2.Admin");
				int selectJoin = sc.nextInt();
				if(selectJoin==1) {
					userJoin();					
				} else if(selectJoin ==2) {
					adminJoin();
				}
			} else if (select == 1) {
				System.out.println("1.User\t2.Admin");
				int select2 = sc.nextInt();
				if(select2 == 1) {
					userLogin();
				} else if(select2 == 2) {
					adminLogin();
				}
			} else {
				break;
			}

		}
	}

	public static void main(String[] args) {
		CompanyApp app = new CompanyApp();
		app.run();
	}

}

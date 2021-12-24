package com.javaex.oop.casting;

public class AnimalApp {

	public static void main(String[] args) {
		// Upcating/Downcasting
		Dog dog1 = new Dog("스누피");
		dog1.eat();
		dog1.walk();
		dog1.bark();
		
		Animal dog2 = new Dog("아지"); // Upcasting: 참조 자료형에 설계된 멤버에만 접근 가능
		dog2.eat();
		dog2.walk();
		
		((Dog)dog2).bark(); // Downcasting
		
		Animal cat1 = new Cat("야옹이"); // Upcasting
		cat1.eat();
		cat1.walk();
		
		if (cat1 instanceof Dog) { // cat1이 Dog의 인스턴스 인가?
			((Dog)cat1).bark(); 
		} else if(cat1 instanceof Cat) { // cat1이 Cat의 인스턴스 인가?
			((Cat)cat1).meow();
		}
		
		
//		Dog[] pets = new Dog[3];
		Animal[] pets = new Animal[3]; // 참조타입을 Animal로 바꿔주면 모두 들어갈 수 있음
		
		pets[0] = dog1;
		pets[1] = (Dog)dog2; // Down
		pets[2] = new Dog("멍멍이");
		pets[2] = new Cat("아즈라엘");
		
		for(Animal pet : pets) {
			pet.eat();
			pet.walk();

			if(pet instanceof Dog) {
				((Dog)pet).bark(); // Down
			} else if(pet instanceof Cat) {
				((Cat)pet).meow(); // Down
			}
		}
	}

}

package com.bitongchong.nowcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 猫狗队列 
 * 【题目】 宠物、狗和猫的类如下：
 * (as the code)
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中； 
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出； 
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例； 
 * 用户可以调用isDogEmpty方法，检查队列中是否有do类的实例； 
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例；
 */
public class Code_4_1_CatDogQueue {
	public static class Pet{
		private String type;
		
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	
	public static class PetEnter{
		private Pet pet;
		private int count;
		public PetEnter(Pet pet, int count){
			this.pet = pet;
			this.count = count;
		}
		public Pet getPet() {
			return this.pet;
		}
		public int getCount() {
			return this.count;
		}
	}
	
	public static class PetQueue{
		private Queue<PetEnter> dogQueue;
		private Queue<PetEnter> catQueue;
		private int count;
		public PetQueue() {
			dogQueue = new LinkedList<PetEnter>();
			catQueue = new LinkedList<PetEnter>();
			count = 0;
		}
		public void push(Pet pet) {
			if (pet.getPetType().equals("dog")) {
				dogQueue.offer(new PetEnter(pet, ++count));
			}else if (pet.getPetType().equals("cat")) {
				catQueue.offer(new PetEnter(pet, ++count));
			}else {
				throw new RuntimeException("the type is wrong");
			}
		}
		public Pet pollAll() {
			//这里如果是直接将两个判断一起括起来在非会出现错误，为什么呢？
			//还不清楚，后面写的时候尽量分开吧
			if (!dogQueue.isEmpty()&&!catQueue.isEmpty()) {
				return dogQueue.peek().getCount()
					>catQueue.peek().getCount()
					?catQueue.poll().getPet()
					:dogQueue.poll().getPet();
			}else if (!dogQueue.isEmpty()) {
				return dogQueue.poll().getPet();
			}else if (!catQueue.isEmpty()) {
				return catQueue.poll().getPet();
			}else {
				throw new RuntimeException("the queue is empty");
			}
		}
		public Cat pollCat() {
			if (catQueue.isEmpty()) {
				throw new RuntimeException("the cat in the queue is empty");
			}
			return (Cat) catQueue.poll().getPet();
		}
		public Dog pollDog() {
			if (dogQueue.isEmpty()) {
				throw new RuntimeException("the dog in the queue is empty");
			}
			return (Dog)dogQueue.poll().getPet();
		}
		public Boolean isEmpty() {
			if (dogQueue.isEmpty()&&catQueue.isEmpty()) {
				return true;
			}else {
				return false;
			}
		}
		public Boolean isDogEmpty() {
			if (dogQueue.isEmpty()) {
				return true;
			}else {
				return false;
			}
		}
		public Boolean isCatEmpty() {
			if (catQueue.isEmpty()) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		PetQueue petQueue = new PetQueue();
		Dog dog = new Dog();
		Cat cat = new Cat();
		petQueue.push(dog);
		petQueue.push(cat);
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		petQueue.push(dog1);
		petQueue.push(cat1);
		petQueue.push(dog1);
		petQueue.push(cat1);
		System.out.println(petQueue.isCatEmpty());
		System.out.println(petQueue.isDogEmpty());
		for (int i = 0; i < 9; i++) {
			petQueue.pollAll();
		}
		System.out.println(petQueue.pollCat().getPetType());
	}
}

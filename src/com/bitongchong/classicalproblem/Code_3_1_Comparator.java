package com.bitongchong.classicalproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//这个是比较器的概念
public class Code_3_1_Comparator {
	public static class Student {
		public String name;
		public int id;
		public int age;
		
		public Student(String name, int id, int age) {
			super();
			this.name = name;
			this.id = id;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
		}
	}
	public static class IdAscComparator implements Comparator<Student>{
		//实现Comparator接口，同时实现（重写）compare方法
		//当返回是负数时，就会认为是方法参数中的前一个排前面，返回正数就是后一个排前面
		public int compare(Student o1, Student o2) {
			return o2.id-o1.id;
		}
	}
	public static class AgeDescComparator implements Comparator<Student>{
		//实现Comparator接口，同时实现（重写）compare方法
		public int compare(Student o1, Student o2) {
			//当返回是负数时，就会认为是前一个排前面，返回正数就是后一个排前面，返回零时，认为两个数是相等的
			return o2.age-o1.age;
		}
	}
	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.print(student.toString()+"  ");
		}
	}
	public static void main(String[] args) {
		Student student1 =new Student("aaaa", 1, 12);
		Student student2 =new Student("bbbb", 2, 234);
		Student student3 =new Student("cccc", 3, 35);
		
		System.out.println("第一列：");
		
		Student[] students = new Student[] {student1,student2,student3};
		Arrays.sort(students, new IdAscComparator());
		printStudents(students);
		
		System.out.println();
		System.out.println("第二列：");
		
		Student[] students2 = new Student[] {student1,student2,student3};
		Arrays.sort(students2, new AgeDescComparator());
		printStudents(students2);
		
		System.out.println();
		System.out.println("第三列：");
		//这个是优先级队列，但是实际上的物理结构是堆，这儿会将排在前面的放在堆顶
		PriorityQueue<Student> heap = new PriorityQueue<>(new AgeDescComparator());
		heap.add(student1);
		heap.add(student2);
		heap.add(student3);
		while(!heap.isEmpty()) {
			Student student = heap.poll();
			System.out.println(student.toString());
		}
	}
}

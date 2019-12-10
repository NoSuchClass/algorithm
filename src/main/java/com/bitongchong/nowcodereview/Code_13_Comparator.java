package com.bitongchong.nowcodereview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_13_Comparator {
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

	public static class IdAscComparator implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.id - s2.id;
		}
	}

	public static class AgeDescComparator implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			return s2.age - s1.age;
		}
	}

	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.print(student.toString() + "  ");
		}
	}

	public static class NewComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			if (o1.id != o2.id) {
				return o1.id - o2.id;
			} else {
				return o2.age - o1.age;
			}
		}
	}

	public static void main(String[] args) {
		Student student1 = new Student("aaaa", 3, 12);
		Student student2 = new Student("bbbb", 2, 234);
		Student student3 = new Student("cccc", 2, 35);

		System.out.println("第一列：");
		Student[] students1 = new Student[] { student1, student2, student3 };
		Arrays.sort(students1, new IdAscComparator());
		printStudents(students1);
		System.out.println();

		System.out.println("第二列：");
		Student[] students2 = new Student[] { student1, student2, student3 };
		Arrays.sort(students2, new AgeDescComparator());
		printStudents(students2);
		System.out.println();
		System.out.println("第三列：");
		// 这个是优先级队列，但是实际上的物理结构是堆，这儿会将排在前面的放在堆顶
		PriorityQueue<Student> queue = new PriorityQueue<>(new NewComparator());
		queue.add(student1);
		queue.add(student2);
		queue.add(student3);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}

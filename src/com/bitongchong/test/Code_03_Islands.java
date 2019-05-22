package com.bitongchong.test;

public class Code_03_Islands {
	public static void func(){
	    for(int i = 0; i < 3; i++){
	        Thread thread = new Thread(new Runnable(){
	        public void run(){
	            System.out.print(Thread.currentThread().getName()+"a");
	    }
	    });
	        
	    thread.start();
	}
	}
	public static void main(String[] args){
	    func();
	}
}
package com.java.pro;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/pro/Wire.xml");
	OrderLogic ol=(OrderLogic)ctx.getBean("orderlogic");
	ol.display();
}
}

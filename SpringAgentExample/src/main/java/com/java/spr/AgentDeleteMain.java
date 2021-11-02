package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentDeleteMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent id   ");
		int agentid = sc.nextInt();
		dao.deleteAgent(agentid);
		System.out.println("*** Record Deleted ***");
	}
}
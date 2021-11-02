package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentUpdateMain {

	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Id   ");
		agent.setAgentid(sc.nextInt());
		System.out.println("Enter Name   ");
		agent.setName(sc.next());
		System.out.println("Enter City   ");
		agent.setCity(sc.next());
		System.out.println("Enter Gender  ");
		agent.setCity(sc.next());
		System.out.println("Enter Maritalstatus  ");
		agent.setMaritalstatus(sc.nextInt());
		System.out.println("Enter Basic   ");
		agent.setPremium(sc.nextDouble());
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		System.out.println(dao.updateAgent(agent));
	}
}
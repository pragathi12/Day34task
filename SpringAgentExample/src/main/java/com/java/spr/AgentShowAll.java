package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentShowAll {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao =(AgentDAO)ctx.getBean("agentDao");
		Agent[] result = dao.showAgent();
		for (Agent agent : result) {
			System.out.println(agent);
		}
	}
}

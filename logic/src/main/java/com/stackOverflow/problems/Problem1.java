/**
 * @(#) Problem1.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package com.stackOverflow.problems;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 403238
 * @since Feb 29, 2016
 * @version 1.0
 */
public class Problem1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/stackOverflow/prob1/spring-context.xml");
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) context.getBean("alJmsFactory");
		System.out.println(factory.getBrokerURL());

	}

}

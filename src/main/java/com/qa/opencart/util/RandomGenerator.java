package com.qa.opencart.util;

import java.util.Random;

public class RandomGenerator {
	
		public static String generateEmailIdGenerator() {
			int len = 5;
			String emailId;
			String chars = "0123456789"
					+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
					+ "abcdefghijklmnopqrstuvwxyz"
					+ "_-";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			
			emailId = sb.append("@gmail.com").toString();
			return emailId;
		}
		
		public static String getEmailId() {
			
			Random randomEmailIdGenerator = new Random();
			String emailId = "SeleniumPractice" + randomEmailIdGenerator.nextInt(10000) + "@gmail.com";
			return emailId;
		}	

}

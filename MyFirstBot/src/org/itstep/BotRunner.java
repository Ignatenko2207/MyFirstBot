package org.itstep;

import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.service.ImitatorService;
import org.itstep.service.Timer;
import org.openqa.selenium.WebDriver;

public class BotRunner {

	public static void main(String[] args) {
		ImitatorService imService = new ImitatorService();
		
		Account acc = new Account("Alex", "Ignatenko", "ignatenko2207@gmail.com", "alexsuperpuper2207");
		
		WebDriver driver = null;
		boolean accIsNotLogined = true;
		int counter = 0;
		
		do {
			counter++;
			
			driver = imService.loginAmazonAccount(acc);
			if(counter>3 || driver.getPageSource().contains("Hello, "+acc.getFirstName())) {
				Timer.waitSeconds(10);
				accIsNotLogined = false;
			} else {
				driver.quit();
			}
			
		} while (accIsNotLogined);
		
		driver = imService.addItemToWL(driver, "B009YQ5IQC");
		
		Timer.waitSeconds(15);
		
		driver.quit();
//		Good good = imService.getItemData("cat toys", "B009YQ5IQC");
//		
//		System.out.println(good.getGoodUrl());
//		System.out.println(good.getPosPage());
//		System.out.println(good.getPosOnSite());
//		imService.registerAmazonAccount(acc);
	}
}

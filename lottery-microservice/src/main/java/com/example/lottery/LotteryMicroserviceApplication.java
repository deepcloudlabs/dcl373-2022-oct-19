package com.example.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.lottery.service.LotteryService;
// -Dspring.profiles.active=test
@SpringBootApplication
public class LotteryMicroserviceApplication implements ApplicationRunner {
	@Autowired
	private LotteryService lotteryService;
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(LotteryMicroserviceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var numbers = lotteryService.draw(100, 10);
		System.out.println(numbers);
		applicationContext.getBeansOfType(Object.class)
		                  .forEach((label,bean) -> {
		   System.out.println("%s: %s".formatted(label,bean.getClass().getName()));             	  
		                  });
	}

}

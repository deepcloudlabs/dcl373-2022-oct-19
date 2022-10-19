package com.example.lottery.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;
import com.example.lottery.service.business.AISupportedLotteryService;
import com.example.lottery.service.business.CheapRandomNumberService;

@Configuration
public class AppConfig {

	@Bean
	@ConditionalOnProperty(name="qualityLevel", havingValue = "cheap")
	RandomNumberService createCheapOne() {
		return new CheapRandomNumberService();
	}
	
	@Bean
	@Primary
	LotteryService createOne(RandomNumberService randomNumberService) {
		return new AISupportedLotteryService(randomNumberService);
	}
}

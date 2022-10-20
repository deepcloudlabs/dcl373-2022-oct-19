package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberService;

@Service
//@ServiceQuality(QualityLevel.SECURE)
//@ConditionalOnProperty(name = "qualityLevel", havingValue = "secure")
@Profile("prod")
public class SecureRandomNumberService implements RandomNumberService {

	private Random random = new SecureRandom();

	@Override
	public int generates(int min, int max) {
		System.out.println("SecureRandomNumberService::generates");		
		return random.nextInt(min, max) ;
	}

}

package com.example.lottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberService;

@Service
//@ServiceQuality(QualityLevel.FAST)
@ConditionalOnProperty(name = "qualityLevel", havingValue = "fast")
public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int generates(int min, int max) {
		System.out.println("FastRandomNumberService::generates");
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}

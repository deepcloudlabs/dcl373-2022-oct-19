package com.example.lottery.service.business;

import java.util.Random;

import com.example.lottery.service.RandomNumberService;

public class CheapRandomNumberService implements RandomNumberService {

	private Random random= new Random();

	@Override
	public int generates(int min, int max) {
		System.out.println("CheapRandomNumberService::generates");
		return random.nextInt(min,max);
	}

}

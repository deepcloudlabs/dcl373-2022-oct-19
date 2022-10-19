package com.example.lottery.service.business;

import java.util.List;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

public class AISupportedLotteryService implements LotteryService {
	private final RandomNumberService randomNumberService;
	
	public AISupportedLotteryService(RandomNumberService randomNumberService) {
		this.randomNumberService = randomNumberService;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return List.of(1, 2, 3, 4, 5, 6,randomNumberService.generates(max));
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return List.of(List.of(1, 2, 3, 4, 5, 6,randomNumberService.generates(max)), List.of(4, 8, 15, 16, 23, 42,randomNumberService.generates(max)));
	}

}

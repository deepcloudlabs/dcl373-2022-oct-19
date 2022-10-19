package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

// Ctrl + Shift + O
// Ctrl + Space
// Ctrl + 1
// Alt + Shift + S
@Service
// default scope is singleton
//@Scope("session") 
//@SessionScope
// Spring Component -> Spring Bean
public class StandardLotteryService implements LotteryService {
	private List<RandomNumberService> randomNumberServices;
	private final AtomicInteger counter= new AtomicInteger(0);
	
	public StandardLotteryService(List<RandomNumberService> randomNumberServices) {
		this.randomNumberServices = randomNumberServices;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		// load balancing
		var index = counter.getAndIncrement() % randomNumberServices.size();
		var randomNumberService = randomNumberServices.get(index);
		return IntStream.generate(() -> randomNumberService.generates(max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .toList();
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return IntStream.range(0, column)
				        .mapToObj(i -> draw(max,size))
				        .toList();
	}

}

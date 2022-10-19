package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

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
	private final RandomNumberService randomNumberService;
	
	public StandardLotteryService(RandomNumberService randomNumberService) {
		this.randomNumberService = randomNumberService;
	}

	@Override
	public List<Integer> draw(int max, int size) {		
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

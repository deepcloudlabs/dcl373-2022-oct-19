package com.example.lottery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.service.business.StandardLotteryService;

@RestController
@RequestMapping("/numbers")
@CrossOrigin
//@RequestScope
public class LotteryRestController {
	private final StandardLotteryService lotteryService;

	public LotteryRestController(StandardLotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	// http://localhost:8100/lottery/api/v1/numbers?max=60&size=6&column=10
	@GetMapping
	public List<List<Integer>> getLotteryNumbers(int max,int size,int column){
		return lotteryService.draw(max, size, column);
	}
}

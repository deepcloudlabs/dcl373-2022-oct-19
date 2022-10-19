package com.example.lottery.service;

import java.util.List;

// Zoom in: Ctrl + Shift + + (plus)
// Zoom out: Ctrl + - 
// Ctrl + Shift + O
public interface LotteryService {
	List<Integer> draw(int max, int size);
	List<List<Integer>> draw(int max, int size,int column);
}

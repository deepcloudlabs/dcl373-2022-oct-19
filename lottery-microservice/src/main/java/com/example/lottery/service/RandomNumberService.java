package com.example.lottery.service;
// Ctrl + Shift + F
public interface RandomNumberService {
	int generates(int min, int max);

	default int generates(int max) {
		return generates(1, max);
	}
}

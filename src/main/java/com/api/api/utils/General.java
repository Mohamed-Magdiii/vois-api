package com.api.api.utils;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class General {

	public String generateRandomPinCode() {
		Random r = new Random();
		int start = 1000000;
		int end = 10000000;
		int result = r.nextInt(end - start) + start;
		return String.valueOf(result);
	}

	public int generateRandomTemp(int min, int max) {
		Random random = new Random();
		int value = random.nextInt(max + min) + min;
		return value;
	}
}

package com.example.bams.uttils;

import java.util.Random;

public class BAMSUtiils {

	public static int generateCustomerID() {
		int n = 10000000 + new Random().nextInt(90000000);
		return n;
	}
}

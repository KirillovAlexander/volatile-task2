package ru.netology;

import java.util.Random;

public class Shop implements Runnable{
    private TaxService taxService;
    private int[] sells = new int[100];

    public Shop(TaxService taxService) {
        Random random = new Random();
        this.taxService = taxService;
        for (int i = 0; i < sells.length; i++) {
            sells[i] = random.nextInt(100);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < sells.length; i++) {
            taxService.add(sells[i]);
        }
        System.out.println(Thread.currentThread().getName() + " закончил подсчет выручки.");
    }
}

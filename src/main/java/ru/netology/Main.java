package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        List<Thread> threadList = startThreads(taxService);
        while (!threadsEnded(threadList));
        System.out.println("Выручка составила: " + taxService.sum());
    }

    private static List<Thread> startThreads(TaxService taxService) {
        List<Thread> threadList = new ArrayList<>();
        threadList.add(new Thread(null, new Shop(taxService), "Shop 1"));
        threadList.add(new Thread(null, new Shop(taxService), "Shop 2"));
        threadList.add(new Thread(null, new Shop(taxService), "Shop 3"));

        for (Thread thread:
             threadList) {
            thread.start();
        }
        return threadList;
    }

    private static boolean threadsEnded(List<Thread> threadList) {
        for (Thread thread:
             threadList) {
            if (thread.isAlive()) return false;
        }
        return true;
    }
}

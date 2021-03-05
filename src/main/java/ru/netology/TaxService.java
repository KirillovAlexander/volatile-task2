package ru.netology;

import java.util.concurrent.atomic.LongAdder;

public class TaxService {
    private static LongAdder longAdder = new LongAdder();

    public void add(long value) {
        longAdder.add(value);
    }

    public long sum() {
        return longAdder.sum();
    }
}

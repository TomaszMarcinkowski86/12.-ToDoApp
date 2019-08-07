package pl.sda.repository;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {


    private static AtomicLong value = new AtomicLong(1);


    public static long getNextValue() {

        return value.getAndIncrement();

    }
}

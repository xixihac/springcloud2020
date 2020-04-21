package test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

    @Test
    public void casTest() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int cur;
        int next;
        do {
            cur = atomicInteger.get();
            next = cur + 1 >= Integer.MAX_VALUE ? 0 : cur + 1;
        } while (!atomicInteger.compareAndSet(cur,next));
    }
}

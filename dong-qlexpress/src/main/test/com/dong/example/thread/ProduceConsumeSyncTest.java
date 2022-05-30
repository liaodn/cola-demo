package com.dong.example.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/10 1:42 下午
 **/
public class ProduceConsumeSyncTest {

    @Test
    public void consumeTest( ) throws InterruptedException {
        ProductConsumeSync sync = new ProductConsumeSync();
        sync.execute("ABAABBAABAB");
    }

    @Test
    public void consumeDubleTest( ) throws InterruptedException {
        ProductConsumeDubleSync sync = new ProductConsumeDubleSync();
        List<Character> input = new ArrayList<>();
        input.add('A');
        input.add('B');
        input.add('B');
        input.add('A');
        input.add('B');
        input.add('A');
        sync.execute(input);
    }
}

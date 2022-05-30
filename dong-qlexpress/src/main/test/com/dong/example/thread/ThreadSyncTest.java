package com.dong.example.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/10 12:26 下午
 **/
public class ThreadSyncTest {

    @Test
    public void testThreadSync(){
        ThreadSync test = new ThreadSync();
        List<Character> input = new ArrayList<>();
        input.add('A');
        input.add('B');
        input.add('B');
        input.add('A');
        input.add('B');
        input.add('A');
        test.execute(input);
    }

}

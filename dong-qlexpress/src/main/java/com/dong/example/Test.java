package com.dong.example;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/4/27 7:58 下午
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 3);
        context.put("b", 2);
        context.put("c", 3);
        String express = "if (a>b) then return a else return b";

//        runner.addFunctionOfServiceMethod("sum",Test.this,new Class[]{Integer.class,Integer.class,null});

        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    public int sum(int i,int j){
        return i+j;
    }


}

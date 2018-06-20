package com.ccitsoft.until;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者、消费者示例
 */
public class ConditionTest1 {
    private int storage;
    private Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition getCondition = lock.newCondition();

    public void put() throws InterruptedException {
        try {
            lock.lock();
            if (storage > 0) {
                putCondition.await();
            }
            storage++;
            System.out.println("put 成功！！！");
            getCondition.signal();
            System.out.println("get ----取得成功--"+"storage:"+storage);
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        try {
            lock.lock();
            if (storage <= 0) {
            	
                getCondition.await();
            }
            storage--;
            System.out.println("get 成功！！!");
            putCondition.signal();
            System.out.println("put----放入成功--"+"storage:"+storage);
        } finally {
            lock.unlock();
        }
    }

    public class PutThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    put();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public class GetThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    get();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        final ConditionTest1 test = new ConditionTest1();
        Thread put = test.new PutThread();
        Thread get = test.new GetThread();
        put.start();
        get.start();
    }
}
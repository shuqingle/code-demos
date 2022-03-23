package com.iamcerco.threadarchdesign.chapter05;

import java.util.concurrent.TimeUnit;

public class SynchornizedDefect {

    public synchronized void syncMethond(){
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchornizedDefect defect = new SynchornizedDefect();
        Thread t1 = new Thread(defect::syncMethond,"T1");
        t1.start();
        TimeUnit.MICROSECONDS.sleep(2);
        Thread t2 = new Thread(defect::syncMethond,"T2");
        t2.start();
        TimeUnit.MICROSECONDS.sleep(2);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}

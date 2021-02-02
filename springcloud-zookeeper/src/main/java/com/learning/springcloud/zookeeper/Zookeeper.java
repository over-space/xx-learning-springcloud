package com.learning.springcloud.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lifang
 * @since 2021/2/2
 */
public class Zookeeper {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = getZK();

        ZooKeeper.States state = zk.getState();
        System.out.println(state);

        //创建节点
        zk.create("/abc", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        //读取数据1
        Stat stat1 = new Stat();
        byte[] data1 = zk.getData("/abc", false, stat1);
        System.out.println("data1: " + new String(data1) + " dataLength : " + stat1.getDataLength());

        System.out.println("----------------------------------------------------------------------------------------");

        //读取数据2
        Stat stat2 = new Stat();
        byte[] data2 = zk.getData("/abc", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watcher-------------------------------");
                System.out.println(watchedEvent.getState());
                System.out.println(watchedEvent.getPath());
                System.out.println(watchedEvent.getType());
                System.out.println("watcher-------------------------------");
            }
        }, stat2);

        System.out.println("data2: " + new String(data2) + " dataLength : " + stat2.getDataLength());
        System.out.println("----------------------------------------------------------------------------------------");

        while (true) {
            System.out.println("----------------------------");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static ZooKeeper getZK() throws IOException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zk = new ZooKeeper("192.168.3.23", 5000, watchedEvent -> {
            System.out.println(watchedEvent.getState().name() + "...");
            switch (watchedEvent.getState()) {
                case SyncConnected:
                    countDownLatch.countDown();
                    break;
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return zk;
    }
}

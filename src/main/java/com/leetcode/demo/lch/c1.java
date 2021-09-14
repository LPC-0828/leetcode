package com.leetcode.demo.lch;

/**
 * <p>
 * <p/>
 *
 * @author Lch
 * @date: 2021.08.30 09:51
 */
public class c1 {

        public static void main(String[] args) {
            Sysshop sysshop = new Sysshop();
            new Factory(sysshop).start();
            new Peopril(sysshop).start();

        }


    /**
     * 生产者
     */
    static class Factory extends Thread{
        Sysshop sysshop;
        Factory(Sysshop sysshop){
            this.sysshop = sysshop;
        }
        @Override
        public void run() {
            //生成鸡
            for (int i = 0; i < 100; i++) {
                try {
                    sysshop.add(new Checken(i));
                    System.out.println("生产了"+i+"只鸡");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */
    static class Peopril extends Thread{
        Sysshop sysshop;
        Peopril(Sysshop sysshop){
            this.sysshop = sysshop;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("吃了"+sysshop.eat().id+"只鸡");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 产品
     */
    static class Checken {
        public int id;
        public Checken(int id){
            this.id = id;
        }
    }

    /**
     * 缓冲区
     */
    static class Sysshop{

        Checken[] checkens = new Checken[10];

        int num = 0;

        public synchronized void add(Checken checken) throws InterruptedException {
            //如果鸡满了，饭店等待
            if(num == checkens.length){
                this.wait();
            }

            //否则添加鸡

            checkens[num] = checken;
            num++;

            this.notifyAll();

        }

        public synchronized Checken eat() throws InterruptedException {
            //如果没有鸡就等待
            if(num ==0){
                this.wait();
            }
            //否则吃鸡
            num--;
            Checken checken = checkens[num];

            this.notifyAll();
            return checken;
        }
    }
}

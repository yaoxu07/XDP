package com.yx.bean;

/**
 * @program: redis-register
 * @description: 统计注册数量！
 * @author: yaoxu
 * @create: 2018-08-27 19:03
 **/
public class CountRegister {
    private int countConsumer;
    private int countProvider ;

    public int getCountConsumer() {
        return countConsumer;
    }

    public void setCountConsumer(int countConsumer) {
        this.countConsumer = countConsumer;
    }

    public int getCountProvider() {
        return countProvider;
    }

    public void setCountProvider(int countProvider) {
        this.countProvider = countProvider;
    }

    public CountRegister(int countConsumer, int countProvider) {
        this.countConsumer = countConsumer;
        this.countProvider = countProvider;
    }

    public CountRegister(int countConsumer) {
        this.countConsumer = countConsumer;
    }

    public CountRegister() {
    }
}

package com.itheima.proxy;

/**
 * 一个生产者
 */
public class Producer implements Iproducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduce(float money){
        System.out.println("销售产品 并拿到钱"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterProduce(float money){
        System.out.println("售后服务 并拿到钱"+money);
    }
}

package com.provider.test;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderTest {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        context.start();
        System.out.println("Dubbo provider is start...");
        try {
            //按任意键退出
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        System.out.println("Dubbo provider is start...");
        try {
            // 按任意键退出
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
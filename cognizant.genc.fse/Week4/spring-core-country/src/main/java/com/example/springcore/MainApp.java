package com.example.springcore;

import com.example.springcore.bean.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Country country = (Country) context.getBean("country");
        System.out.println(country);
    }
}

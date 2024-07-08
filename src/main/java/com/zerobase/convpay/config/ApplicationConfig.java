package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import com.zerobase.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
// 4. JavaConfig ComponentsScan 을 통한 Bean 등록
// @ComponentScan(basePackages = "com.zerobase.convpay")
@ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {

    /* 3. JavaConfig 를 통한 Bean 등록
    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(moneyAdapter(), cardAdapter())
                ),
                discountByConvenience()
        );
    }

    @Bean
    public MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public DiscountByConvenience discountByConvenience() {
        return new DiscountByConvenience();
    }

    @Bean
    public DiscountByPaymethod discountByPaymethod() {
        return new DiscountByPaymethod();
    }
    */



}

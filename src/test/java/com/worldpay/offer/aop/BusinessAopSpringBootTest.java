package com.worldpay.offer.aop;

import com.worldpay.offer.aop.business.AOPBusiness1;
import com.worldpay.offer.aop.business.AOPBusiness2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AOPBusiness1 business1;

    @Autowired
    private AOPBusiness2 business2;

    @Test
    public void invokeAOPStuff() {
        logger.info(business1.calculateSomething());
        logger.info(business2.calculateSomething());
    }
}
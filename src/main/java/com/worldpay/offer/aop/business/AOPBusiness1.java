package com.worldpay.offer.aop.business;

import com.worldpay.offer.aop.around.TrackTime;
import com.worldpay.offer.aop.dao.AOPDao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AOPBusiness1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AOPDao1 dao1;

    @TrackTime
    public String calculateSomething(){
        //Business Logic
        String value = dao1.retrieveSomething();
        logger.info("In Business - {}", value);
        return value;
    }
}

package com.worldpay.offer.aop.business;


import com.worldpay.offer.aop.dao.AOPDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AOPBusiness2 {

    @Autowired
    private AOPDao2 dao2;

    public String calculateSomething(){
        //Business Logic
        return dao2.retrieveSomething();
    }
}

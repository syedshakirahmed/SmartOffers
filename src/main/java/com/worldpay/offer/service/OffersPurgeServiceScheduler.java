package com.worldpay.offer.service;

import com.worldpay.offer.dao.OfferDAO;
import com.worldpay.offer.entity.OfferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class OffersPurgeServiceScheduler {
    @Autowired
    OfferDAO offerDAO;
    int size;
        @Scheduled(fixedRate = 600000)
        public void purgeRecords()
        {
            Iterable<OfferDetails> result = offerDAO.findAll();
            for (OfferDetails offer : result) {
                if (offer.getExpirationDate().before(new Date())) {
                    offerDAO.deleteById(offer.getOfferId());
                    size++;
                }
            }
            System.out.println("Total expired Offer Records has been Deleted :: "+size );
            size = 0;
        }
    }

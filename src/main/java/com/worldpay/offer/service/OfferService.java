package com.worldpay.offer.service;

import com.worldpay.offer.dao.OfferDAO;
import com.worldpay.offer.entity.OfferDetails;
import com.worldpay.offer.exception.GlobalExceptionHandler;
import com.worldpay.offer.model.common.Error;
import com.worldpay.offer.model.resources.OfferDetailsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OfferService {

    @Autowired
    OfferDAO offerDAO;

    public OfferDetailsResource getOffer(Long offerId) throws Exception {
        OfferDetails offerDetails = offerDAO.findById(offerId).get();
        if(offerDetails.getExpirationDate().before(new Date())) {
            throw new NoSuchElementException();
        }
        return new OfferDetailsResource(offerDetails.getOfferName(), offerDetails.getOfferDescription(), offerId);
    }

    public Iterable<OfferDetails> getAllOffers(){
        List<OfferDetails> result = new ArrayList<>();
        for (OfferDetails offer : offerDAO.findAll()) {
            if(!offer.getExpirationDate().before(new Date())) {
                result.add(offer);
            }
        }
        return result;
    }

    public String cancelOffer(Long offerId) {
        OfferDetails offerDetails = offerDAO.findById(offerId).get();
        if (offerDetails != null)
         offerDAO.deleteById(offerId);

        return "The Offer has been deleted "+offerId;
    }

    public OfferDetailsResource createOffer(OfferDetails offerDetails) throws Exception {
        offerDAO.save(offerDetails);
        return new OfferDetailsResource(offerDetails.getOfferName(),offerDetails.getOfferDescription(),offerDetails.getOfferId());

    }
}

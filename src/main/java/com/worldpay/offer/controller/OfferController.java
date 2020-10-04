package com.worldpay.offer.controller;

import com.worldpay.offer.entity.OfferDetails;
import com.worldpay.offer.model.resources.OfferDetailsResource;
import com.worldpay.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.Long.valueOf;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    OfferService offerService;


    @GetMapping(value = "/reads/{offerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferDetailsResource> getOffer(@PathVariable("offerId") String offerId) throws Exception {
        OfferDetailsResource offerDetailsResource = offerService.getOffer(valueOf(offerId));
        return ResponseEntity.ok(offerDetailsResource);
    }
    @GetMapping("/AllOffers")
    public Iterable<OfferDetails> getOffers() {
        return offerService.getAllOffers();
    }
    @PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OfferDetailsResource> createOffer(@RequestBody OfferDetails offerDetails)
            throws Exception {
        OfferDetailsResource offerDetailsResource = offerService.createOffer(offerDetails);
        return ResponseEntity.ok(offerDetailsResource);
    }

    @GetMapping(value="/cancel/{offerId}")
    @ResponseStatus(HttpStatus.OK)
    public String cancelOffer(@PathVariable("offerId") String offerId){
        return offerService.cancelOffer(valueOf(offerId));
    }

}

package com.worldpay.offer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OFFER_DETAILS")
public class OfferDetails {



    @Id
    @GeneratedValue
    @Column(name = "OFFER_ID")
    Long offerId;

    @Column(name = "OFFER_NAME")
    String offerName;

    @Column(name = "DESCRIPTION")
    String offerDescription;

    @Column(name = "OFFER_PRICE")
    Long price;

    @Column(name = "CURRENCY")
    String currency;

    @Column(name = "EXPIRATION_DATE")
    Date expirationDate;

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public OfferDetails() {
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public Long getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}

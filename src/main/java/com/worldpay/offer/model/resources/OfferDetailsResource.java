package com.worldpay.offer.model.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.worldpay.offer.controller.OfferController;
import com.worldpay.offer.entity.OfferDetails;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@JsonPropertyOrder({"offer name","offer description"})
public class OfferDetailsResource extends ResourceSupport {

    @JsonProperty("offer name")
    private String offerName;

    @JsonProperty("offer description")
    private String offerDescription;

    @JsonIgnore
    Long offerId;

    public OfferDetailsResource(String offerName, String offerDescription, Long offerId) throws Exception {
        this.offerName = offerName;
        this.offerDescription = offerDescription;
        this.offerId = offerId;
       add(linkTo(methodOn(OfferController.class).getOffer(String.valueOf(offerId))).withSelfRel());
        add(linkTo(methodOn(OfferController.class).getOffers()).withRel("AllOffers"));
        OfferDetails offerDetails = new OfferDetails();
        add(linkTo(methodOn(OfferController.class).createOffer(offerDetails)).withRel("Create"));

    }
}

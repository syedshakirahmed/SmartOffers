package com.worldpay.offer.dao;

import com.worldpay.offer.entity.OfferDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferDAO extends CrudRepository<OfferDetails,Long> {

}

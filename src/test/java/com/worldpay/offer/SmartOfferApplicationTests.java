package com.worldpay.offer;

import com.worldpay.offer.controller.OfferController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SmartOfferApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OfferController offerController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(offerController).isNotNull();
	}

	@Test
	public void givenApiCallToGetValidOfferIdThenEnsureThereIsAnOfferNameInAResponse() throws Exception {
		this.mockMvc.perform(get("/api/offers/reads/10001")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Sample Offer 10001")));
	}

	@Test
	public void givenApiCallToGetValidOfferIdhenEnsureThereIsAnOfferDescriptionInAResponse() throws Exception {
		this.mockMvc.perform(get("/api/offers/reads/10001")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Sample Offer Description")));
	}

	@Test
	public void givenApiCallToGetInvalidOfferNumberThenEnsureResponseIsNotFound() throws Exception {
		this.mockMvc.perform(get("/api/offers/reads/1000")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Offer ID does not exist")));
	}

	@Test
	public void givenApiCallToCancelOfferWithValidOfferIdThenEnsureThereIsResponse() throws Exception {
		this.mockMvc.perform(get("/api/offers/cancel/10001")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("he Offer has been deleted")));
	}

	@Test
	public void givenApiCallToCancelOfferWithInValidOfferIdThenEnsureResponseIsNotFound() throws Exception {
		this.mockMvc.perform(get("/api/offers/reads/1000")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Offer ID does not exist")));
	}

	@Test
	public void givenApiCallToGetAllOffersThenEnsureResponse() throws Exception {
		this.mockMvc.perform(get("/api/offers/AllOffers")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Sample Offer 10001")));
	}

	@Test
	public void givenApiCallToGetAllOfferThenEnsureTheExpiredOffersShouldNotBePartOfResponse() throws Exception {
		this.mockMvc.perform(get("/api/offers/AllOffers")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string( not("Sample Offer 10004")));
	}

}

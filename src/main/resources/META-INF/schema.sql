DROP TABLE IF EXISTS OFFER_DETAILS;

CREATE TABLE OFFER_DETAILS (
  offer_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250),
  price NUMBER(5) NOT NULL,
  currency VARCHAR(250) NOT NULL,
  expiration_date VARCHAR(250)

);

insert into OFFER_DETAILS
        values(10001,'SampleOffer1','sampledescription1',199,'GBP','31/12/2020');

insert into OFFER_DETAILS
        values(10002,'SampleOffer2','sampledescription2',299,'GBP','31/12/2020');

insert into OFFER_DETAILS
        values(10003,'SampleOffer3','sampledescription3',399,'GBP','31/12/2020');

insert into OFFER_DETAILS
        values(10004,'SampleOffer4','sampledescription4',499,'GBP','31/12/2020');

commit;
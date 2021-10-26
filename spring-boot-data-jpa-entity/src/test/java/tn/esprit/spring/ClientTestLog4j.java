package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.ClientServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest


public class ClientTestLog4j {

@Autowired
ClientServiceImpl client;

private static final Logger l = LogManager.getLogger(ClientTestLog4j.class);

@Test
public void testRetrieveClient() {
l.info("retrieveClient : "+ client);
}


}
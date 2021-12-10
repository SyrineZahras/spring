package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientIMLPService implements ClientService{

@Autowired 
ClientRepository cr;

@Override
public Client Addc(Client C) {
	return cr.save(C);
}
}

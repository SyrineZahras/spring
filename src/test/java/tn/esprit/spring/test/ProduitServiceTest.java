package tn.esprit.spring.test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceTest {
@Autowired
ClientService cs;
	
@Test
public void TestAdd() throws ParseException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date ds=dateFormat.parse("15/03/1996");
	
	Client c= new Client("skander", "turki", null, "ss@h.com", "3asba", CategorieClient.Fidele, Profession.Cadre);
	cs.Addc(c);
}
}

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.detailFacture;
import tn.esprit.spring.service.ProduitService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {

@Autowired
ProduitService produitservice;

//"Skander", "turki", datedeNaissance, "skanturki@gmail.com", "123", CategorieClient.Fidele , Profession.Cadre
@Test
public void TestCreateProduit() throws ParseException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date datedeNaissance =dateFormat.parse("02/10/1991");
	DetailProduit dp= new DetailProduit(null, null, null, null, null);
	Stock S= new Stock(null, null, null, null); 
	Fournisseur F= new Fournisseur("1220", "Saida");
	HashSet<Produit>  hset= new HashSet<>();
	Rayon R= new Rayon("110", "sucré", hset);
	Client C= new Client("Skander", "turki", (java.sql.Date) datedeNaissance, "skanturki@gmail.com", "123", CategorieClient.Fidele , Profession.Cadre);
	Facture Fac=new Facture(0, 50000, null, true, null, null)
	detailFacture df= new detailFacture(50, 50000, 0, 0, hset, null);
	
	Produit P = new Produit("1011", "Gaucho", 1200 , dp, S, F, R, df);
}
	

}

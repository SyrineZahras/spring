package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClientRepositoryTests {
 
    @Autowired
    private ClientRepository repo;
     
    @Test
    @Rollback(false)
    public void testCreateProduct() {
        Client addClient = repo.save(new Client(null, "syrine", "zahras", null, "syrine.zah@live.fr", null, null, null, null));
        Client addClient1 = repo.save(new Client(null, "foulen", "Ben Foulen", null, "foulen@live.com", null, null, null, null));

         
        assertThat(addClient1.getIdClient()).isGreaterThan(0);
    }
    
    @Test
    public void testListClients() {
        List<Client> clients = (List<Client>) repo.findAll();
        assertThat(clients).size().isGreaterThan(0);
    }
    
    @Test
    @Rollback(false)
    public void testUpdateClient() {
        Client client = repo.findById((long) 2).orElse(null);
        
        client.setPrenom("cc");
         
        repo.save(client);
         
        Client updatedClient = repo.findById((long) 2).orElse(null);
         
        assertThat(updatedClient.getPrenom());
    } 
    
    @Test
    public void testDeleteClient() {
        Client client = repo.findById((long) 4).orElse(null);
         
        repo.deleteById(client.getIdClient());
         
        Client deletedClient = repo.findById((long) 4).orElse(null);
         
        assertThat(deletedClient).isNull();       
         
    }
}



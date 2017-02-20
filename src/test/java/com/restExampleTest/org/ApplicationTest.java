package com.restExampleTest.org;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.restExample.org.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
@DirtiesContext
public class ApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGreeting() throws Exception {
    	
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + "/", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testGreetingReturnsCorrectOutput(){
    	ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + "/greeting", String.class);
    	assertEquals(HttpStatus.OK, entity.getStatusCode());
    	assertEquals("{\"id\":1,\"content\":\"Hi, User\"}",entity.getBody());
    }
    
    @Test
    public void testGreetingReturnsCorrectOutputWhenUserNameGivenAsInput(){
    	ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + "/greeting?name=madhu", String.class);
    	assertEquals(HttpStatus.OK, entity.getStatusCode());
    	assertEquals("{\"id\":2,\"content\":\"Hi, madhu\"}",entity.getBody());
    }
    
    
}

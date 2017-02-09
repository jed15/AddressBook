package com.controller;

import com.AddressBook;
import com.AddressBookRepository;
import com.BuddyInfo;
import com.BuddyInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by jeremydunsmore on 2/2/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddressBookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    @Test
    public void addBuddy() throws Exception {
        ResponseEntity<String> response = template.getForEntity("http://localhost:"+port+"/add?bookid=1&name=Matt&phone=123",
                String.class);
        assertNotNull(addressBookRepository.findOne(1));
        BuddyInfo buddy=buddyInfoRepository.findOne(1);
        assertEquals("Matt",buddy.getName());
        assertEquals("123",buddy.getPhone());

        response = template.getForEntity("http://localhost:"+port+"/add?bookid=1&name=Pete&phone=987&address=654",
                String.class);
        buddy=buddyInfoRepository.findByName("Pete").get(0);
        assertEquals("654", buddy.getAddress());

    }



    @Test
    public void getBook() throws Exception {
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Matt","123","567"));
        addressBookRepository.save(book);
        ResponseEntity<String> response = template.getForEntity("http://localhost:"+port+"/get?id=1",
                String.class);

        assertThat(response.getBody(),equalTo("{\"buddies\":[{\"id\":1,\"name\":\"Matt\",\"phone\":\"123\",\"address\":\"567\"}],\"id\":1}"));
    }

    @Test
    public void removeBuddy() throws Exception {
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Matt","123"));
        addressBookRepository.save(book);
        ResponseEntity<String> response = template.getForEntity("http://localhost:"+port+"/remove?bookid="+book.getId()+"&buddyId=1",
                String.class);

        assertThat(response.getBody(),equalTo("{\"buddies\":[],\"id\":1}"));
        assertNull(buddyInfoRepository.findOne(1));
    }

}
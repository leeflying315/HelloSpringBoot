package com.lifei.spring.example.demo;

import com.lifei.spring.example.demo.cd.CompactDisc;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*
* Spring写法
* RunWith(SpringJUnit4ClassRunner.class)，
* 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
 * */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=DemoApplication.class)

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-dev.yml")
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CompactDisc cd;

    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }
}
package com.zhangwenit.mybatis.spring.demo;

import com.zhangwenit.mybatis.spring.demo.model.Person;
import com.zhangwenit.mybatis.spring.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisSpringDemoApplication.class)
public class MybatisSpringDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

//    @Autowired
//    private PersonService personService;
//
//    @Test
//    public void test() throws Exception {
//        Person byId = personService.getById(1L);
//    }

}

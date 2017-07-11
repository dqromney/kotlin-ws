package com.dqr.kotlin.persistence;

import com.dqr.kotlin.model.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
public class DataSetupBean implements InitializingBean {

    @Autowired
    private PersonRepository repo;

    @Override
    public void afterPropertiesSet() throws Exception {
        IntStream.range(1, 5).forEach(i -> repo.save(new Person(randomAlphabetic(8))));
    }

}

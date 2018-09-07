package com.sale.runner;

import com.sale.repo.LocalDataRepository;
import com.sale.service.impl.MessageProcessingServiceImpl;

/**
 * This class is responsible to trigger SalesMessagingApplication
 */
public class SalesAppRunner {

    public static void main(String[] args){
        new MessageProcessingServiceImpl(new LocalDataRepository()).process();
    }
}

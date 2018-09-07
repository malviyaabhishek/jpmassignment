package com.sale;


import com.sale.repo.LocalDataRepository;
import com.sale.service.impl.MessageProcessingServiceImpl;
import com.sale.service.impl.ReportGenerationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageProcessingServiceTest {

    MessageProcessingServiceImpl messageProcessingService = null;

    @Before
    public void setUp(){
        messageProcessingService = new MessageProcessingServiceImpl(new LocalDataRepository());
    }

    @Test
    public void testMessageProcessing(){
        Assert.assertTrue(messageProcessingService.process());
    }

}

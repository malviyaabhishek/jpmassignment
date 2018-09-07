package com.sale.service.impl;

import com.sale.SalesProcessorException;
import com.sale.constant.AdjustmentType;
import com.sale.constant.MessageType;
import com.sale.model.SalesMessage;
import com.sale.repo.Repository;
import com.sale.service.SalesProcessingService;

import java.math.BigDecimal;
import java.util.Queue;

public class MessageProcessingServiceImpl{

    private ReportGenerationServiceImpl reportGenerationService = new ReportGenerationServiceImpl();
    private Repository repository;

    public MessageProcessingServiceImpl(Repository repository){
        this.repository = repository;
    }

    public boolean process() {
        int processCount = 0;
        boolean successFlag = false;
        Queue<String> msgQueue = repository.getMsgQueue();

        while (!msgQueue.isEmpty()) {
            String msgStr = msgQueue.poll();
            processCount++;
            successFlag = processMessage(msgStr);
            successFlag = generateReports(repository, processCount);
            if(successFlag)
                break;
        }
        return successFlag;
    }

    private boolean processMessage(String msgStr) {
        if(msgStr!=null && !msgStr.isEmpty()){
            String msgArray[] = msgStr.split(",");
            String productType = msgArray[0];
            SalesMessage salesMessage = null;

            try {
                salesMessage = new SalesMessage();
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
                return false;
            }

            try {
                buildAndProcessMessage(msgArray, salesMessage);
                return true;
            } catch (SalesProcessorException e) {
                System.err.println(e.getMessage());
            }
            return false;

        }

        return false;
    }

    private void buildAndProcessMessage(String[] msgArray, SalesMessage salesMessage) throws SalesProcessorException{
        salesMessage.getSale().setProductType(msgArray[1]);

        if(msgArray[0]!=null && !msgArray[0].isEmpty()) {
            populateMessageType(msgArray[0], salesMessage);
        }

        try{
            salesMessage.getSale().setPrice(new BigDecimal(msgArray[2]));
        }catch(Exception e){
            throw new SalesProcessorException("Incorrect input");
        }

        try{
            salesMessage.getSale().setQuantity(Integer.parseInt(msgArray[3]));
        }catch(Exception e){
            salesMessage.getSale().setQuantity(1);
            throw new SalesProcessorException("Incorrect input "+MessageType.Type2.name());
        }

        populateAdjustmentFields(msgArray, salesMessage);
    }

    private void populateAdjustmentFields(String[] msgArray, SalesMessage salesMessage) throws SalesProcessorException {
        if(salesMessage.getMessageType().equals(MessageType.Type3)){
            salesMessage.setAdjustment(true);

            try{
                salesMessage.getAdjustment().setPrice(new BigDecimal(msgArray[2]));
            }catch(Exception e){
                throw new SalesProcessorException("Incorrect input "+MessageType.Type3.name());
            }

            try{
                salesMessage.getAdjustment().setQuantity(Integer.parseInt(msgArray[3]));
            }catch(Exception e){
                throw new SalesProcessorException("Incorrect input "+MessageType.Type3.name());
            }


            String adjustmentOperation = msgArray[4];
            if(adjustmentOperation!=null && !adjustmentOperation.isEmpty())
                salesMessage.getAdjustment().setAdjustmentType(AdjustmentType.valueOf(adjustmentOperation));
        }

        if(salesMessage.isAdjustment())
            repository.addAdjustmentItem(salesMessage);
        else
            repository.addSalesItem(salesMessage);
    }

    private void populateMessageType(String s, SalesMessage salesMessage) {
        switch (s) {
            case "Type1":
                salesMessage.setMessageType(MessageType.Type1);
                break;
            case "Type2":
                salesMessage.setMessageType(MessageType.Type2);
                break;
            case "Type3":
                salesMessage.setMessageType(MessageType.Type3);
                break;
            default:
                System.err.println("Not supporting MesssageType for Sale message");
         }
    }

    private boolean generateReports(Repository repository, int processCount) {
        if (processCount % 10 == 0) {
            System.out.println(reportGenerationService.generateSalesReport(repository.getSalesItemList()));
        }
        if (processCount == 50) {
            System.out.println(reportGenerationService.generateAdjustmentReport(repository.getAdjustmentItemList()));
            return true;
        }
        return false;
    }
}

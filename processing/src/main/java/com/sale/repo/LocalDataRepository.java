package com.sale.repo;

import com.sale.model.SalesMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LocalDataRepository implements Repository{

    private String fileName = "";
    public List<SalesMessage> salesMessageList = new ArrayList<>();
    public Queue<String> msgQueue = new LinkedList<>();
    private List<SalesMessage> salesItemList = new ArrayList<>();
    private List<SalesMessage> adjustmentItemList = new ArrayList<>();

    public LocalDataRepository(){
        loadMessages();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<SalesMessage> getSalesMessageList() {
        return salesMessageList;
    }

    public void setSalesMessageList(List<SalesMessage> salesMessageList) {
        this.salesMessageList = salesMessageList;
    }

    public Queue<String> getMsgQueue() {
        return msgQueue;
    }

    public void setMsgQueue(Queue<String> msgQueue) {
        this.msgQueue = msgQueue;
    }

    @Override
    public List<SalesMessage> getSalesItemList() {
        return salesItemList;
    }

    @Override
    public void addSalesItem(SalesMessage salesMessage) {
        this.salesItemList.add(salesMessage);
    }

    @Override
    public List<SalesMessage> getAdjustmentItemList() {
        return adjustmentItemList;
    }

    @Override
    public void addAdjustmentItem(SalesMessage salesMessage) {
        this.adjustmentItemList.add(salesMessage);
    }

    @Override
    public void loadMessages(){
        try {

            Path paths = Paths.get("salesData.txt").toAbsolutePath();
            List<String> msgList = Files.readAllLines(Paths.get("src/main/resources/salesData.txt").toAbsolutePath());
            msgQueue.addAll(msgList);
        } catch (IOException e) {
            System.err.println("Error occured while reading file:"+e);
        }
    }


}

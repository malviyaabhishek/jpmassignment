package com.sale.repo;

import com.sale.model.SalesMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface Repository {

    public Queue<String> getMsgQueue();
    public void setMsgQueue(Queue<String> msgQueue1);
    public void loadMessages();
    public List<SalesMessage> getSalesItemList();
    public List<SalesMessage> getAdjustmentItemList();
    public void addSalesItem(SalesMessage salesMessage);
    public void addAdjustmentItem(SalesMessage salesMessage);

}

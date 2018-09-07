package com.sale.service.impl;

import com.sale.model.Sale;
import com.sale.model.SalesMessage;
import com.sale.service.SalesProcessingService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGenerationServiceImpl{

    public String generateSalesReport(List<SalesMessage> salesItemList) {
        Map<String, BigDecimal> productPriceMap = new HashMap<>();
        Map<String, Integer> productQuantityMap = new HashMap<>();

        BigDecimal totalAmount = BigDecimal.ZERO;
        int totalUnitsSold = 0;

        Set<String> productSet = salesItemList.stream().map(s -> s.getSale().getProductType()).collect(Collectors.toSet());

        for(SalesMessage salesMessage: salesItemList){
            Sale sale = salesMessage.getSale();
            String productType = sale.getProductType();
                BigDecimal priceValue = productPriceMap.containsKey(productType)?
                        productPriceMap.get(productType).add(sale.getPrice()):sale.getPrice();

                productPriceMap.put(sale.getProductType(), priceValue);


                Integer quantityValue = productQuantityMap.containsKey(productType)?
                        productQuantityMap.get(productType)+sale.getQuantity():sale.getQuantity();

                 productQuantityMap.put(sale.getProductType(), quantityValue);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("************************SalesReport**********************Generated After 10 Trades*******************\n");
        for (Map.Entry<String, BigDecimal> entry : productPriceMap.entrySet()) {
            totalUnitsSold += productQuantityMap.get(entry.getKey());
                     sb.append(entry.getKey())
                    .append(" --> quantity: ").append(productQuantityMap.get(entry.getKey()))
                    .append(", price: ").append(entry.getValue().toString()).append("\n");
            totalAmount = totalAmount.add(entry.getValue());
        }
        sb.append("\n-----------------------------\n");
        sb.append("Total quantity: " + totalUnitsSold)
                .append("\n").append("Total Amount: ")
                .append(totalAmount.toString())
                .append("\n-----------------------------\n");
        return sb.toString();

    }

    public String generateAdjustmentReport(List<SalesMessage> adjustmentMessageList) {
        StringBuilder sb = new StringBuilder();
        sb.append("********************Application is pausing for a moment until the report is generated************\n");
        sb.append("************************AdjustmentReport****************Generated after 50 Trades****************\n");
        for (SalesMessage salesMessage : adjustmentMessageList) {
                    sb.append(salesMessage).append("\n");
        }
        return sb.toString();
    }
}

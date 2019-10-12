package com.example.demo.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Receipt {

    private String orderer;
    private String placeName;
    private String phoneNumber;
    private String receiptNumber;
    private Date reservationDate;

    public Receipt(String orderer, String placeName, String phoneNumber, Date reservationDate) {
        setOrderer(orderer);
        setPlaceName(placeName);
        setPhoneNumber(phoneNumber);
        setReservationDate(reservationDate);
        setReceiptNumber();
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    private void setOrderer(String orderer) {
        this.orderer = orderer;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber() {
        this.receiptNumber = generateReceiptNumber();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    private String generateReceiptNumber() {
        String returnString = "";
        List<String> list = Arrays.asList("1","2","3","4","5","6","7","8","9");
        for(int i = 0; i < 25; i++) {
            int random = (int)(Math.random() * (list.size() - 1) + 1);
            returnString += list.get(random);
        }
        return returnString;

    }

    public String getOrderer() {
        return orderer;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

}
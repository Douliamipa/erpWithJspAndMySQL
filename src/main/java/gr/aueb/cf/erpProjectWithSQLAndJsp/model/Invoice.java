package gr.aueb.cf.erpProjectWithSQLAndJsp.model;

import java.sql.Date;

public class Invoice {
    private Long id ;
    private String invoiceNo ;
    private  Client client ;
    private java.sql.Date date ;
    private String vatStatus ;
    private String paymentMethod ;
    private String  VatExemption ;
    private double amount ;
    private double vatPercentage ;
    private double totalAmount ;

    private Invoice(){}


    public Invoice(Long id, String invoiceNo, Client client, Date date, String vatStatus, String paymentMethod, String vatExemption, double amount, double vatPercentage, double totalAmount) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.client = client;
        this.date = date;
        this.vatStatus = vatStatus;
        this.paymentMethod = paymentMethod;
        this.VatExemption = vatExemption;
        this.amount = amount;
        this.vatPercentage = vatPercentage;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getVatStatus() {
        return vatStatus;
    }

    public void setVatStatus(String vatStatus) {
        this.vatStatus = vatStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getVatExemption() {
        return VatExemption;
    }

    public void setVatExemption(String vatExemption) {
        VatExemption = vatExemption;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }
}

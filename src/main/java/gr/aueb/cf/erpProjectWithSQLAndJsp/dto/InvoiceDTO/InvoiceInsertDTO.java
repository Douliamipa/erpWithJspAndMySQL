package gr.aueb.cf.erpProjectWithSQLAndJsp.dto.InvoiceDTO;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.Base;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;

import java.sql.Date;
import java.util.Objects;

public class InvoiceInsertDTO  extends Base {
    private String invoiceNo ;
    private Client client ;
    private java.sql.Date date ;
    private String vatStatus ;
    private String paymentMethod ;
    private String  VatExemption ;
    private double amount ;
    private double vatPercentage ;
    private double totalAmount ;

    public InvoiceInsertDTO(){}

    public InvoiceInsertDTO(String invoiceNo, Client client, Date date, String vatStatus, String paymentMethod, String vatExemption, double amount, double vatPercentage, double totalAmount) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "InvoiceInsertDTO{" +
                "invoiceNo='" + invoiceNo + '\'' +
                ", client=" + client +
                ", date=" + date +
                ", vatStatus='" + vatStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", VatExemption='" + VatExemption + '\'' +
                ", amount=" + amount +
                ", vatPercentage=" + vatPercentage +
                ", totalAmount=" + totalAmount +
                '}';
    }

}

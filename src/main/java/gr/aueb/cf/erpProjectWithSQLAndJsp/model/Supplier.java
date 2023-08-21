package gr.aueb.cf.erpProjectWithSQLAndJsp.model;

public class Supplier {
    private Integer id ;
    private String CompanysName ;
    private long vatNo ;

    private String street;
    private String streetNo ;
    private String city;
    private int zipCode ;
    private String country ;
    private String paymentMethod;
    private String accountingCategory ;

    public Supplier(){}

    public Supplier(Integer id, String companysName, long vatNo, String street, String streetNo, String city, int zipCode, String country, String paymentMethod, String accountingCategory) {
        this.id = id;
        this.CompanysName = companysName;
        this.vatNo = vatNo;
        this.street = street;
        this.streetNo = streetNo;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.paymentMethod = paymentMethod;
        this.accountingCategory = accountingCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanysName() {
        return CompanysName;
    }

    public void setCompanysName(String companysName) {
        CompanysName = companysName;
    }

    public long getVatNo() {
        return vatNo;
    }

    public void setVatNo(long vatNo) {
        this.vatNo = vatNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAccountingCategory() {
        return accountingCategory;
    }

    public void setAccountingCategory(String accountingCategory) {
        this.accountingCategory = accountingCategory;
    }
}

package gr.aueb.cf.erpProjectWithSQLAndJsp.model;

public class Client {
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

    public Client(){}

    public Client(Integer id, String companysName, long vatNo, String street, String streetNo, String city, int zipCode, String country, String paymentMethod, String accountingCategory) {
        this.id = id;
        CompanysName = companysName;
        this.vatNo = vatNo;
        this.street = street;
        this.streetNo = streetNo;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.paymentMethod = paymentMethod;
        this.accountingCategory = accountingCategory;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public int getId() {
        return id;
    }

    public String getCompanysName() {
        return CompanysName;
    }

    public Long getVatNo() {
        return vatNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getAccountingCategory() {
        return accountingCategory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanysName(String companysName) {
        CompanysName = companysName;
    }

    public void setVatNo(long vatNo) {
        this.vatNo = vatNo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAccountingCategory(String accountingCategory) {
        this.accountingCategory = accountingCategory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", CompanysName='" + CompanysName + '\'' +
                ", vatNo=" + vatNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", accountingCategory='" + accountingCategory + '\'' +
                '}';
    }
}

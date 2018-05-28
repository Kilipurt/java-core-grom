package lesson36.models;

public class Filter {
    private String country;
    private String city;
    private String hotelName;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Integer numberOfGuests;
    private Double maxPrice;

    public Filter(String country, String city, String hotelName, Boolean breakfastIncluded, Boolean petsAllowed, Integer numberOfGuests, Double maxPrice) {
        this.country = country;
        this.city = city;
        this.hotelName = hotelName;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.numberOfGuests = numberOfGuests;
        this.maxPrice = maxPrice;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }
}

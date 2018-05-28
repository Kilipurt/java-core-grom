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

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getMaxPrice() {
        return maxPrice;
    }
}

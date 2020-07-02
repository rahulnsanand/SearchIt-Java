package com.searchit.tfg.dataset.retrieve;

public class ZomatoWebOrder {

    private String restaurantID;
    private String restaurantName;
    private String countryCode;
    private String city;
    private String address;
    private String locality;
    private String localityVerbose;
    private String longitude;
    private String latitude;
    private String cuisines;
    private String averageCostForTwo;
    private String currency;
    private String hasTableBooking;
    private String hasOnlineDelivery;
    private String isDeliveringNow;
    private String priceRange;
    private String aggregateRating;
    private String ratingColor;
    private String ratingText;
    private String votes;
    private String thumbURL;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private int retryNo;

    public int getRetryNo() {
        return retryNo;
    }

    public void setRetryNo(int retyNo) {
        this.retryNo = retyNo;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setLocalityVerbose(String localityVerbose) {
        this.localityVerbose = localityVerbose;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public void setAverageCostForTwo(String averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setHasTableBooking(String hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public void setHasOnlineDelivery(String hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    public void setIsDeliveringNow(String isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setAggregateRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getLocalityVerbose() {
        return localityVerbose;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getCuisines() {
        return cuisines;
    }

    public String getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public String getCurrency() {
        return currency;
    }

    public String getHasTableBooking() {
        return hasTableBooking;
    }

    public String getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public String getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getAggregateRating() {
        return aggregateRating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public String getRatingText() {
        return ratingText;
    }

    public String getVotes() {
        return votes;
    }

    public ZomatoWebOrder() {
    }

    public ZomatoWebOrder(String restaurantID, String restaurantName, String countryCode, String city, String address, String locality, String localityVerbose, String longitude, String latitude, String cuisines, String averageCostForTwo, String currency, String hasTableBooking, String hasOnlineDelivery, String isDeliveringNow, String priceRange, String aggregateRating, String ratingColor, String ratingText, String votes) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.countryCode = countryCode;
        this.city = city;
        this.address = address;
        this.locality = locality;
        this.localityVerbose = localityVerbose;
        this.longitude = longitude;
        this.latitude = latitude;
        this.cuisines = cuisines;
        this.averageCostForTwo = averageCostForTwo;
        this.currency = currency;
        this.hasTableBooking = hasTableBooking;
        this.hasOnlineDelivery = hasOnlineDelivery;
        this.isDeliveringNow = isDeliveringNow;
        this.priceRange = priceRange;
        this.aggregateRating = aggregateRating;
        this.ratingColor = ratingColor;
        this.ratingText = ratingText;
        this.votes = votes;
    }

    @Override
    public String toString() {
        return  "restaurantID='" + restaurantID + '\'' + "\n"+
                "restaurantName='" + restaurantName + '\'' +"\n"+
                "countryCode='" + countryCode + '\'' +"\n"+
                "city='" + city + '\'' +"\n"+
                "address='" + address + '\'' +"\n"+
                "locality='" + locality + '\'' +"\n"+
                "localityVerbose='" + localityVerbose + '\'' +"\n"+
                "longitude='" + longitude + '\'' +"\n"+
                "latitude='" + latitude + '\'' +"\n"+
                "cuisines='" + cuisines + '\'' +"\n"+
                "averageCostForTwo='" + averageCostForTwo + '\'' +"\n"+
                "currency='" + currency + '\'' +"\n"+
                "hasTableBooking='" + hasTableBooking + '\'' +"\n"+
                "hasOnlineDelivery='" + hasOnlineDelivery + '\'' +"\n"+
                "isDeliveringNow='" + isDeliveringNow + '\'' +"\n"+
                "priceRange='" + priceRange + '\'' +"\n"+
                "aggregateRating='" + aggregateRating + '\'' +"\n"+
                "ratingColor='" + ratingColor + '\'' +"\n"+
                "ratingText='" + ratingText + '\'' +"\n"+
                "votes='" + votes + '\'' +"\n"+
                "thumbURL='" + thumbURL + '\'' +"\n"+
                "phoneNumber='" + phoneNumber + '\'' +"\n";
    }
}

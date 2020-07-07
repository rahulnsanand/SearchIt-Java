package com.searchit.tfg.dataset.retrieve;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

public class ZomatoAPISearch {

    private int retry = 0;
    private int APIRetry = 0;
    private final String[] API_KEY = new String[3];
    private static JsonObject jsonObject;

    public int getApiDetails(ZomatoWebOrder zomatoWebOrder, String res_id){

        try {
            if (res_id.equals("NA") || res_id.equals("NULL")) {
                return -1;
            }
            API_KEY[0] = "ddc19ec4e7244f81d2ef270dfba9ae31";
            API_KEY[1] = "75bf90cb1deb1ebb903f36ffdfe18b54";

            String res_id_url = "res_id=" + res_id + "\"";
            String request_url = " \"https://developers.zomato.com/api/v2.1/restaurant?" + res_id_url;
            String api_id = " \"user-key: " + API_KEY[APIRetry] + "\"" + request_url;
            String url = "curl -X GET --header \"Accept: application/json\" --header" + api_id;

            String responseHTTP = "https://developers.zomato.com/api/v2.1/restaurant?res_id=" + res_id;

            if (getResponseCode(responseHTTP) == 200) {
                try {
                    Reader reader = new InputStreamReader(Runtime.getRuntime().exec(url).getInputStream());
                    jsonObject = new JsonParser().parse(reader).getAsJsonObject();
                    setDetails(zomatoWebOrder);
                    return 1;
                } catch (NullPointerException nullPointerException) {
                    return 100;
                } catch (SocketTimeoutException timeoutException) {
                    if (retry < 3) {
                        retry++;
                        return getApiDetails(zomatoWebOrder, res_id);
                    } else {
                        return 101;
                    }
                } catch (IOException e) {
                    return 102;
                }
            }
            if (getResponseCode(responseHTTP) == 440) {
                if (APIRetry < 3) {
                    APIRetry++;
                    getApiDetails(zomatoWebOrder, res_id);
                } else {
                    return 104;
                }
            }

            return getResponseCode(responseHTTP);
        }
        catch(NullPointerException nullPointerException){
            return 105;
        }
    }

    public int getResponseCode(String responseHTTP){
        int statusCode = 0;
        try {
            URL statusCheckURL = new URL(responseHTTP);
            HttpURLConnection http = (HttpURLConnection)statusCheckURL.openConnection();
            http.setRequestProperty("user_key",API_KEY[APIRetry]);
            statusCode = http.getResponseCode();
            return statusCode;
        }
        catch (UnknownHostException e){
            return 103;
        }
        catch (IOException e){
            return 102;
        }
    }

    public void setDetails(ZomatoWebOrder zomatoWebOrder){
        zomatoWebOrder.setRestaurantID(jsonObject.get("R").getAsJsonObject().get("res_id").toString());
        zomatoWebOrder.setThumbURL(jsonObject.get("thumb").toString());
        zomatoWebOrder.setAddress(jsonObject.get("location").getAsJsonObject().get("address").toString());
        zomatoWebOrder.setAggregateRating(jsonObject.get("user_rating").getAsJsonObject().get("aggregate_rating").toString());
        zomatoWebOrder.setAverageCostForTwo(jsonObject.get("average_cost_for_two").toString());
        zomatoWebOrder.setCity(jsonObject.get("location").getAsJsonObject().get("city").toString());
        zomatoWebOrder.setCountryCode(jsonObject.get("location").getAsJsonObject().get("country_id").toString());
        zomatoWebOrder.setCuisines(jsonObject.get("cuisines").toString());
        zomatoWebOrder.setCurrency(jsonObject.get("currency").toString());
        zomatoWebOrder.setHasOnlineDelivery(jsonObject.get("has_online_delivery").toString());
        zomatoWebOrder.setHasTableBooking(jsonObject.get("has_table_booking").toString());
        zomatoWebOrder.setIsDeliveringNow(jsonObject.get("is_delivering_now").toString());
        zomatoWebOrder.setLatitude(jsonObject.get("location").getAsJsonObject().get("latitude").toString());
        zomatoWebOrder.setLongitude(jsonObject.get("location").getAsJsonObject().get("longitude").toString());
        zomatoWebOrder.setLocality(jsonObject.get("location").getAsJsonObject().get("locality").toString());
        zomatoWebOrder.setLocalityVerbose(jsonObject.get("location").getAsJsonObject().get("locality_verbose").toString());
        zomatoWebOrder.setPriceRange(jsonObject.get("price_range").toString());
        zomatoWebOrder.setVotes(jsonObject.get("user_rating").getAsJsonObject().get("votes").toString());
        zomatoWebOrder.setRatingColor(jsonObject.get("user_rating").getAsJsonObject().get("rating_color").toString());
        zomatoWebOrder.setRatingText(jsonObject.get("user_rating").getAsJsonObject().get("rating_text").toString());
        zomatoWebOrder.setRestaurantName(jsonObject.get("name").toString());
        zomatoWebOrder.setPhoneNumber(jsonObject.get("phone_numbers").toString());
        zomatoWebOrder.setRetryNo(retry);
    }

    private static final String[] API_KEY_STATIC = new String[3];
    private static int retry_STATIC = 0;
    private static int APIRetry_STATIC = 0;
    public static int getResponseCodeStatic(String responseHTTP){
        int statusCode = 0;
        try {
            URL statusCheckURL = new URL(responseHTTP);
            HttpURLConnection http = (HttpURLConnection)statusCheckURL.openConnection();
            http.setRequestProperty("user_key",API_KEY_STATIC[APIRetry_STATIC]);
            statusCode = http.getResponseCode();
            return statusCode;
        }
        catch (UnknownHostException e){
            return 103;
        }
        catch (IOException e){
            return 102;
        }
    }

    public static void getJsonObjectAsJson(String destination) {
        FileWriter file = null;
        try {
            file = new FileWriter(destination);
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static String getRegion(String res_id){
        String region = "";
        try {
            if (res_id.equals("NA") || res_id.equals("NULL")) {
                return "Doesn't exist anymore";
            }
            API_KEY_STATIC[0] = "ddc19ec4e7244f81d2ef270dfba9ae31";
            API_KEY_STATIC[1] = "75bf90cb1deb1ebb903f36ffdfe18b54";

            String res_id_url = "res_id=" + res_id + "\"";
            String request_url = " \"https://developers.zomato.com/api/v2.1/restaurant?" + res_id_url;
            String api_id = " \"user-key: " + API_KEY_STATIC[APIRetry_STATIC] + "\"" + request_url;
            String url = "curl -X GET --header \"Accept: application/json\" --header" + api_id;

            String responseHTTP = "https://developers.zomato.com/api/v2.1/restaurant?res_id=" + res_id;

            if (getResponseCodeStatic(responseHTTP) == 200) {
                try {
                    Reader reader = new InputStreamReader(Runtime.getRuntime().exec(url).getInputStream());
                    JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

                    region = jsonObject.get("location").getAsJsonObject().get("locality").toString();

                    return region;
                } catch (SocketTimeoutException timeoutException) {
                    if (retry_STATIC < 3) {
                        retry_STATIC++;
                    }
                    return "";
                } catch (NullPointerException | IOException nullPointerException) {
                    return "";
                }
            }
            if (getResponseCodeStatic(responseHTTP) == 440) {
                if (APIRetry_STATIC < 3) {
                    APIRetry_STATIC++;
                    getRegion(res_id);
                } else {
                    return "";
                }
            }

            return "";
        }
        catch(NullPointerException nullPointerException){
            return "";
        }
    }

}

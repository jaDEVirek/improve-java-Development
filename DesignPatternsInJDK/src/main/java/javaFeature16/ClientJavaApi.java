package javaFeature16;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class ClientJavaApi {


    public static void main(String[] args) throws IOException, URISyntaxException {
        ClientJavaApi clientJavaApi = new ClientJavaApi();
       Map<String, Object> response = new ObjectMapper().readValue(clientJavaApi.callGet(), HashMap.class);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        String countries = gson.toJson(response.get("Countries"));
        Country[] countries1 = gson.fromJson(countries, Country[].class);
        System.out.println(countries);
        List.of(countries1).forEach(System.out::println);


        //        String countries = gson.toJson(re sponse.get("Countries"));
//        System.out.println(countries);
//        Type type = new TypeToken<List<ArrayList<String>>>(){}.getType();
//        Object countries1 = response.get("Countries");
//        System.out.println(countries1);
////        gson.fromJson(, type);

    }


    public String callGet() {

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> exchange = rest.exchange(
                "https://api.covid19api.com/summary",
                HttpMethod.GET,
                HttpEntity.EMPTY, String.class);
        return exchange.getBody();

    }
}

class Country {
    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("country='")
                .append(country)
                .append('\'');
        sb.append(", countryCode='")
                .append(countryCode)
                .append('\'');
        sb.append(", slug='")
                .append(slug)
                .append('\'');
        sb.append(", newConfirmed=")
                .append(newConfirmed);
        sb.append(", totalConfirmed=")
                .append(totalConfirmed);
        sb.append(", newDeaths=")
                .append(newDeaths);
        sb.append(", totalDeaths=")
                .append(totalDeaths);
        sb.append(", newRecovered=")
                .append(newRecovered);
        sb.append(", totalRecovered=")
                .append(totalRecovered);
        sb.append(", date='")
                .append(date)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;
    String country;
    String countryCode;
    String slug;
    int newConfirmed;
    int totalConfirmed;
    int newDeaths;
    int totalDeaths;
    int newRecovered;
    int totalRecovered;
    String date;


    public Country() {
    }

    public Country(String id, String country, String countryCode, String slug, int newConfirmed, int totalConfirmed, int newDeaths,
            int totalDeaths, int newRecovered, int totalRecovered, String date) {
        this.id=id;
        this.country = country;
        this.countryCode = countryCode;
        this.slug = slug;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getTotalconfirmed() {
        return totalConfirmed;
    }

    public void setTotalconfirmed(int totalconfirmed) {
        this.totalConfirmed = totalconfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package javaFeature16;



import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

public class ClientJavaApi {


    public static void main(String[] args) throws IOException, URISyntaxException {
        String s = new ClientJavaApi().callGet();
        System.out.println(s);

    }

    public String callGet() {

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> exchange = rest.exchange(
                "https://api.github.com/users/octocat",
                HttpMethod.GET,
                HttpEntity.EMPTY, String.class);
        return exchange.getBody();

    }
}

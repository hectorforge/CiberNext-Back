package pe.edu.cibernext.services.impl;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.stereotype.Service;

@Service
public class EmailValidatorService {

    // @Value("${abstract.api.key}")
    // private String API_KEY;

    // @Value("${abstract.api.url}")
    // private String API_URL;

    public boolean isValidEmail(String email) {
        // Versión comentada que usaba la API externa:
        /*
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                    .queryParam("api_key", API_KEY)
                    .queryParam("email", email)
                    .toUriString();

            String response = restTemplate.getForObject(url, String.class);

            if (response != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response);
                String deliverability = jsonNode.get("deliverability").asText();
                return "DELIVERABLE".equalsIgnoreCase(deliverability);
            }

            return false;
        } catch (Exception e) {
            System.out.println("Error verificando email: " + e.getMessage());
            return false;
        }
        */

        // Versión simplificada temporal: siempre retorna true
        return true;
    }
}

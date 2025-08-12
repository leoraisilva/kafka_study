package br.study.kafka.api.clients;

import br.study.kafka.api.dto.CarPostDTO;
import br.study.kafka.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URL = "http://localhost:8080/api/v1/user";
    private final String POSTS_STORE_SERVICE_URL = "http://localhost:8080/api/v1/sales";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> getCarPostsClient() {
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URL+"/car/", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostSalesClient(OwnerPostDTO ownerPostDTO) {
        restTemplate.postForObject(USER_STORE_SERVICE_URL, ownerPostDTO, OwnerPostDTO.class);
    }

    public void removeCarPostSalesClient(String id) {
        restTemplate.delete(POSTS_STORE_SERVICE_URL+"/car/"+id);
    }

    public void changeCarPostSalesClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(POSTS_STORE_SERVICE_URL+"/car/"+id, carPostDTO ,CarPostDTO.class);
    }

}

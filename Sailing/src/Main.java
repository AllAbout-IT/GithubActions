// GoogleSearchService.java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleSearchService {

  @Value("${google.api.key}") // application.properties에 정의한 Google API 키
  private String apiKey;

  @Value("${google.custom.search.engine.id}") // application.properties에 정의한 검색 엔진 ID
  private String cx;

  private final String apiUrl = "https://www.googleapis.com/customsearch/v1";

  private final RestTemplate restTemplate;

  public GoogleSearchService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String search(String query) {
    String requestUrl = String.format("%s?key=%s&cx=%s&q=%s", apiUrl, apiKey, cx, query);
    return restTemplate.getForObject(requestUrl, String.class);
  }
}

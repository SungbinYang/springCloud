package me.sungbin.feign.mapService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocalSearchService {

    private static final String authKey = "KakaoAK b97d2826a8bea9ad7b43c6654a3009b7";

    private KakaoLocalSearchClient kakaoLocalSearchClient;

    public LocalSearchService(KakaoLocalSearchClient kakaoLocalSearchClient) {
        this.kakaoLocalSearchClient = kakaoLocalSearchClient;
    }

    public ResponseEntity<LocalSearchResponseWrapper> findLocationReturnMap(String keyword) {
        return kakaoLocalSearchClient.findLocation(authKey, keyword);
    }

    public ResponseEntity<LocalSearchResponse> findResponse(String keyword) {
        return kakaoLocalSearchClient.findResponse(authKey, keyword);
    }

    public ResponseEntity<String> findLocation(String keyword) {
        return kakaoLocalSearchClient.findLocationWithHeader(authKey, keyword);
    }
}

package me.sungbin.feign.mapService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MapServiceTest {

    @Autowired
    LocalSearchService localSearchService;

    Integer locationId = 992254166;

    @Test
    void localSearch() {

        LocalSearchResponse searchResponse = new LocalSearchResponse();

        LocalSearchResponseWrapper localSearchResponseWrapper = localSearchService.findLocationReturnMap("배곧생명공원").getBody();

        System.out.println(localSearchResponseWrapper.getLocalSearchResponses());

        List<LocalSearchResponse> localSearchResultList = localSearchResponseWrapper.getLocalSearchResponses().stream()
                .filter(p -> p.getId().equals(locationId))
                .collect(Collectors.toList());

        assertEquals(1, localSearchResultList.size(), "사이즈는 1이어야 합니다.");

        localSearchResultList.forEach(p -> {
            searchResponse.setPlaceUrl(p.getPlaceUrl());
            searchResponse.setPhone(p.getPhone());
        });

        String searchLocationResult = String.format("전화번호: %s, 지도url: %s", searchResponse.getPhone(), searchResponse.getPlaceUrl());

        System.out.println(searchLocationResult);
    }

}
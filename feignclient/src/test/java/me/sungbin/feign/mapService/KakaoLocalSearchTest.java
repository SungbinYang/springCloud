package me.sungbin.feign.mapService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class KakaoLocalSearchTest {

    @Autowired
    KakaoLocalSearchClient kakaoLocalSearchClient;

    @Test
    public void findLocation() {
        String query = "생명공원";
        String authHeaderValue = "KakaoAK b97d2826a8bea9ad7b43c6654a3009b7";

        ResponseEntity<String> response = kakaoLocalSearchClient.findLocationWithHeader(authHeaderValue, query);

        System.out.println(response);

        /**
         * <200 OK OK,{"documents":[{"address_name":"경기 시흥시 정왕동 2506","category_group_code":"",
         * "category_group_name":"","category_name":"여행 \u003e 공원 \u003e 도시근린공원","distance":"",
         * "id":"992254166","phone":"","place_name":"배곧생명공원","place_url":"http://place.map.kakao.com/992254166",
         * "road_address_name":"경기 시흥시 배곧2로 25","x":"126.72148058981489","y":"37.37140952971964"},
         * {"address_name":"경북 성주군 월항면 인촌리","category_group_code":"","category_group_name":"","category_name":"여행 \u003e 공원",
         * "distance":"","id":"1804381533","phone":"","place_name":"생명문화공원","place_url":"http://place.map.kakao.com/1804381533",
         * "road_address_name":"","x":"128.29788540162","y":"36.0141102949868"},{"address_name":"경기 시흥시 정왕동 1771-7",
         * "category_group_code":"PK6","category_group_name":"주차장","category_name":"교통,수송 \u003e 교통시설 \u003e 주차장",
         * "distance":"","id":"545207545","phone":"","place_name":"배곧생명공원 주차장","place_url":"http://place.map.kakao.com/545207545",
         * "road_address_name":"","x":"126.720320210072","y":"37.3701417551596"},{"address_name":"경기 시흥시 정왕동 1772-33",
         * "category_group_code":"","category_group_name":"","category_name":"가정,생활 \u003e 유아 \u003e 놀이시설 \u003e 놀이터",
         * "distance":"","id":"2137217159","phone":"","place_name":"배곧생명공원 놀이터","place_url":"http://place.map.kakao.com/2137217159",
         * "road_address_name":"","x":"126.724479721277","y":"37.372476157231"},{"address_name":"경기 시흥시 정왕동 2506","category_group_code":"",
         * "category_group_name":"","category_name":"교통,수송 \u003e 자동차 \u003e 전기자동차 충전소","distance":"","id":"296569648","phone":"1522-1782",
         * "place_name":"배곧생명공원주차장 전기차충전소","place_url":"http://place.map.kakao.com/296569648","road_address_name":"","x":"126.72449136952",
         * "y":"37.3733042243019"},{"address_name":"충북 제천시 왕암동 660","category_group_code":"CT1","category_group_name":"문화시설",
         * "category_name":"문화,예술 \u003e 문화시설 \u003e 전시관","distance":"","id":"25429595","phone":"043-653-4588","place_name":"제천한방엑스포공원 한방생명과학관",
         * "place_url":"http://place.map.kakao.com/25429595","road_address_name":"충북 제천시 한방엑스포로 19","x":"128.159711805057","y":"37.1437187473162"},
         * {"address_name":"충북 제천시 왕암동 660","category_group_code":"","category_group_name":"","category_name":"문화,예술 \u003e 문화시설","distance":"",
         * "id":"26546133","phone":"","place_name":"제천한방엑스포공원 한방생명과학관 다목적강당","place_url":"http://place.map.kakao.com/26546133",
         * "road_address_name":"충북 제천시 한방엑스포로 19","x":"128.159712135188","y":"37.1437403683267"},
         * {"address_name":"서울 서초구 원지동 50-5","category_group_code":"","category_group_name":"","category_name":"여행 \u003e 공원시설물","distance":"",
         * "id":"135034624","phone":"","place_name":"청계산도시자연공원 생명의숲","place_url":"http://place.map.kakao.com/135034624","road_address_name":"","x":"127.043685386468",
         * "y":"37.4553259683989"}],"meta":{"is_end":true,"pageable_count":8,"same_name":{"keyword":"생명공원","region":[],"selected_region":""},"total_count":8}},
         * [access-control-allow-headers:"Authorization, KA, Origin, X-Requested-With, Content-Type, Accept", access-control-allow-methods:"GET, OPTIONS", access-control-allow-origin:"*", connection:"keep-alive",
         * content-type:"application/json; charset=utf-8", date:"Sun, 12 Sep 2021 13:28:57 GMT", server:"nginx", transfer-encoding:"chunked", vary:"Accept-Encoding", x-request-id:"61c9eed0-13cd-11ec-af7f-9b6256153880"]>
         */

        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}
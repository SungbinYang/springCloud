package me.sungbin.feign.mapService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalSearchResponseWrapper {

    @JsonProperty("documents")
    private List<LocalSearchResponse> localSearchResponses;

    @JsonProperty("meta")
    private LocalSearchMeta localSearchMeta;

    public static class LocalSearchMeta {

    }
}

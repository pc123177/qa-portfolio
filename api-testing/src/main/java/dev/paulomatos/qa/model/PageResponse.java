package dev.paulomatos.qa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponse<T> {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<T> data;
}

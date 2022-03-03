package com.example.dong.common.page;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class PaginationResultDTO<T>  {


    private int pageNum;

    private int pageSize;

    private long total;

    private int totalPages;

    @NonNull
    private List<T> data;

    private PaginationResultDTO(){
        this.pageNum = 1;
        this.pageSize = 10;
        this.total = 0;
        this.totalPages = 0;
        this.data = Collections.emptyList();
    }

    //use PaginationResultDTO.of(data)
    private PaginationResultDTO(List<T> data) {
        this.data = data;
        this.pageNum = 1;
        this.pageSize = data.size();
        this.total = data.size();
        this.totalPages = 1;
    }

    //use PaginationResultDTO.of(page)
    private PaginationResultDTO(Page<T> page) {
        this.pageNum = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.total = page.getTotalElements();
        this.data = page.getContent();
        this.totalPages = page.getTotalPages();
    }

    public static <T> PaginationResultDTO<T> of(List<T> data) {
        return new PaginationResultDTO<>(data);
    }

    public static <T> PaginationResultDTO<T> of(Page<T> page) {
        return new PaginationResultDTO<>(page);
    }

    public static <T> PaginationResultDTO<T> of(PaginationResultDTO<?> other, List<T> data) {
        PaginationResultDTO<T> result = new PaginationResultDTO<>();
        result.pageNum = other.getPageNum();
        result.pageSize = other.getPageSize();
        result.total = other.getTotal();
        result.data = data;
        result.totalPages = other.getTotalPages();
        return result;
    }

    public static <T> PaginationResultDTO<T> of(PaginationResultDTO<?> other, List<T> data,List<T> data2) {
        PaginationResultDTO<T> result = of(other,data);
        if(null !=  data2 && data2.size() > 0){
            result.setTotal(result.getTotal() + data2.size());
            result.setTotalPages((int) (result.getTotal()/result.getPageSize()));
            if(null == result.getData()){
                result.setData(new ArrayList<>());
            }
            if(result.getData().size() < result.getPageSize()){
                result.getData().addAll(data2);
            }
        }
        return result;
    }
}

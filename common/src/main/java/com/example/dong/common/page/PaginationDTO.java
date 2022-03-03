package com.example.dong.common.page;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PaginationDTO<T> {

    /**
     * 默认的分页大小
     */
    private static final int DEFAULT_PAGE_SIZE = 10;


    private int pageNum;

    private int pageSize;

    private T condition;

    private Sort sort = Sort.unsorted();

    /**
     * 默认构造函数
     */
    public PaginationDTO() {
        this(1, DEFAULT_PAGE_SIZE);
    }

    /**
     * @param pageNum     页数
     * @param pageSize 每页记录数
     */
    public PaginationDTO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }


    public void setSort(Sort sort) {
        this.sort = sort != null ? sort : Sort.unsorted();
    }

    public static <T> PaginationDTO<T> of(int pageNum, int pageSize) {
        return new PaginationDTO<>(pageNum, pageSize);
    }

    public static <T> PaginationDTO<T> of(int pageNum, int pageSize, Sort sort) {
        PaginationDTO<T> dto = new PaginationDTO<>(pageNum, pageSize);
        dto.setSort(sort);
        return dto;
    }

}

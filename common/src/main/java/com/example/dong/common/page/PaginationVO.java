package com.example.dong.common.page;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class PaginationVO<T> {

    /**
     * 默认的分页大小
     */
    private static final int DEFAULT_PAGE_SIZE = 10;

    private int pageNum;

    private int pageSize;

    private T condition;

    private Map<String, String> sort;

    /**
     * 默认构造函数
     */
    public PaginationVO() {
        this(1, DEFAULT_PAGE_SIZE);
    }

    /**
     * @param pageNum     页数
     * @param pageSize 每页记录数
     */
    public PaginationVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PaginationDTO<T> to() {
        PaginationDTO<T> p = PaginationDTO.of(pageNum, pageSize);
        p.setCondition(getCondition());
        List<Sort.Order> orders = new ArrayList<>();
        if (sort != null && !sort.isEmpty()) {
            sort.forEach((k, v) -> {
                orders.add(new Sort.Order(Sort.Direction.fromString(v), k));
            });
            p.setSort(Sort.by(orders));
        }
        return p;
    }

}

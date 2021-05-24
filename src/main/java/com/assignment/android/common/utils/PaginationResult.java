package com.assignment.android.common.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationResult<E> implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private int totalRecords;
    private int currentPage;
    private List<E> listRecord;
    private int maxResult;
    private int totalPages;
    private int fromRecordIndex;

    public PaginationResult(int page, int maxResult, int pTotalRecords) {
        final int pageIndex = page - 1 < 0 ? 0 : page - 1;
        int fromRecordIndex = pageIndex * maxResult;

        // Total Records
        this.totalRecords = pTotalRecords;
        this.currentPage = pageIndex + 1;
        this.maxResult = maxResult;
        this.fromRecordIndex = fromRecordIndex;
        if (this.totalRecords % this.maxResult == 0) {
            this.totalPages = this.totalRecords / this.maxResult;
        } else {
            this.totalPages = (this.totalRecords / this.maxResult) + 1;
        }
    }
}

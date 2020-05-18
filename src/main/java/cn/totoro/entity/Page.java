package cn.totoro.entity;

import javax.validation.constraints.Size;

public class Page {

    @Size(min=1)
    private Integer page; //当前页码
    @Size(min=1)
    private Integer pageSize; //页面大小
    private Integer totalPages; //分页数量



    private Integer totalElements; //总数

    public Page(){

    }

    public Page(Integer page, Integer pageSize) {
        this.page = (page-1)*pageSize;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = (page-1)*pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }


    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }


    public Integer getTotalElements() {
        return totalElements;
    }


    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }


    /**
     * 在这进行判断页码数量
     * @param totalElements
     */
    public void setTotalElementsAndTotalPages(Integer totalElements) {
        if (totalElements> 0 && this.pageSize > 0){
            this.totalElements = totalElements;
            if(totalElements%pageSize == 0){
                this.totalPages = totalElements/pageSize;
            }else{
                this.totalPages = totalElements/pageSize+1;
            }
        }else{
            this.totalElements = 0;
            this.totalPages = 0;
        }

    }
}

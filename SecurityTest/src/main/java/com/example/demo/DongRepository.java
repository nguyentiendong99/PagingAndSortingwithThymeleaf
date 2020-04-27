package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DongRepository extends PagingAndSortingRepository<Dong , Integer> {
    @Query("select c from Dong c where c.username like '%' || :keyword || '%' " +
            "or c.address like '%' || :keyword || '%' " +
            "or c.email like '%' || :keyword || '%'" +
            "or c.nameproduct like '%' || :keyword || '%'")
    List<Dong> findByUsername(@Param("keyword") String keyword);
}

package com.nguyenz.repository;

import com.nguyenz.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,String> {

    @Query(value = "select d from District d where d.provinceId = ?1")
    List<District> getDistrictByProvinceId(String provinceId);
}

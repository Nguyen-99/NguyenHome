package com.nguyenz.repository;

import com.nguyenz.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward,String> {
    @Query("select w from Ward w where w.districtId = ?1")
    List<Ward> getWardByDistrictId(String districtId);
}

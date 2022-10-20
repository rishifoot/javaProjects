package com.exittest.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exittest.backend.model.Serviceavailibility;

@Repository
public interface ServiceavailibilityDao extends JpaRepository<Serviceavailibility, Long> {

	public List<Serviceavailibility> findByPincode(Long pincode);

}

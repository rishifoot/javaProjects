package com.exittest.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exittest.backend.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}

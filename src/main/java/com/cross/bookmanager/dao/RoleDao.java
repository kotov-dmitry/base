package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}

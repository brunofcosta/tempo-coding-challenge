package com.tempo.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tempo.challenge.domain.Role;


/**
 * @author Bruno
 *
 */
public interface RoleRepository extends JpaRepository<Role, String> {

}

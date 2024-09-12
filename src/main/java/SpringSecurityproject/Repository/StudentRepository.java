package SpringSecurityproject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import SpringSecurityproject.Entity.Students;


public interface StudentRepository extends JpaRepository<Students, Integer>{
	
}
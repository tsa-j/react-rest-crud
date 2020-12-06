package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.NewElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewElementRepository extends JpaRepository<NewElement, Long> {

}
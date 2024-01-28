package com.example.LibraryManagmentSystem;

import com.example.LibraryManagmentSystem.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {

}

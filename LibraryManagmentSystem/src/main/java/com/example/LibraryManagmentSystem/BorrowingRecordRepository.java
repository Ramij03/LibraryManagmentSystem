package com.example.LibraryManagmentSystem;

import com.example.LibraryManagmentSystem.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    BorrowingRecord findByBookIdAndPatronId(Long bookId, Long patronId);
}

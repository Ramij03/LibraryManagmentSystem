package com.example.LibraryManagmentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    public void borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = patronRepository.findById(patronId).orElse(null);
        if (book != null && patron != null) {
            BorrowingRecord borrowingRecord = new BorrowingRecord();
            borrowingRecord.setBook(book);
            borrowingRecord.setPatron(patron);
            borrowingRecord.setBorrowingDate(LocalDate.now());
            borrowingRecordRepository.save(borrowingRecord);

        }
    }
    public void returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);
        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(LocalDate.now());
            borrowingRecordRepository.save(borrowingRecord);

        }
    }
}

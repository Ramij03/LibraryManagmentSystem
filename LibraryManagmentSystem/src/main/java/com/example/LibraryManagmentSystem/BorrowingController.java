package com.example.LibraryManagmentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/{bookId}/patron/{patronId}")
    public void borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowingService.borrowBook(bookId, patronId);
    }

    @PutMapping("/{bookId}/patron/{patronId}")
    public void returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowingService.returnBook(bookId, patronId);
    }
}
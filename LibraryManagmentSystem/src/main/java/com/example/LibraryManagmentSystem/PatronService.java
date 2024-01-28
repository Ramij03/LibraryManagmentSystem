package com.example.LibraryManagmentSystem;
import com.example.LibraryManagmentSystem.Patron;
import com.example.LibraryManagmentSystem.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patron) {
        if (patronRepository.existsById(id)) {
            patron.setId(id);
            return patronRepository.save(patron);
        }
        return null; // or throw an exception
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
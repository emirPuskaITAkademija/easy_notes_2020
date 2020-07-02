package com.example.itakademija.easy_notes_2020.business.controller;

import com.example.itakademija.easy_notes_2020.business.model.Note;
import com.example.itakademija.easy_notes_2020.business.repository.NoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    /**
     * Fetch all notes from DB
     *
     * @return notes
     */
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    
    /**
     * Fetch note by ID
     * @param id
     * @return note
     */
    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable Integer id){
        return noteRepository.getOne(id);
    }
    
    /**
     * Add notes
     * @param note
     * 
     */
    @PostMapping("/notes")
    public void addNote(@Validated @RequestBody Note note){
        noteRepository.save(note);
    }

}

package com.example.itakademija.easy_notes_2020.business.repository;

import com.example.itakademija.easy_notes_2020.business.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    //
}

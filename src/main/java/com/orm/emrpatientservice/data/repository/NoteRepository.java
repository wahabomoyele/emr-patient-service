package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.entry.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

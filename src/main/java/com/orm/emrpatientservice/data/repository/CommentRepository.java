package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.entry.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

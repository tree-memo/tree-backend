package com.example.tree.repository;

import com.example.tree.model.Letter;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByUserId(Long userId);
}

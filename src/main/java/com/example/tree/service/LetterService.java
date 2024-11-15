package com.example.tree.service;

import com.example.tree.model.Letter;
import com.example.tree.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    @Autowired
    private LetterRepository letterRepository;

    public Letter createLetter(Long userId, Long decorationId, Letter letter) {
        // 편지 작성 로직
        return letterRepository.save(letter);
    }

    public List<Letter> getAllLetters() {
        return letterRepository.findAll();
    }
}

package com.example.tree.controller;

import com.example.tree.model.Decoration;
import com.example.tree.model.Letter;
import com.example.tree.model.Option;
import com.example.tree.service.DecoService;
import com.example.tree.service.DecorationService;
import com.example.tree.service.LetterService;
import com.example.tree.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreeController {

    private final LetterService letterService;
    private final DecorationService decorationService;
    private final OptionService optionService;

    @Autowired
    public TreeController(LetterService letterService, DecorationService decorationService, OptionService optionService) {
        this.letterService = letterService;
        this.decorationService = decorationService;
        this.optionService = optionService;
    }

    // 모든 편지 보기
    @GetMapping("/letters")
    public List<Letter> getAllLetters() {
        return letterService.getAllLetters();
    }

    // 특정인의 편지 보기
    @GetMapping("/letters/{letterId}")
    public ResponseEntity<Letter> getLetterById(@PathVariable Long letterId) {
        return letterService.getLetterById(letterId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 장식 보기
    @GetMapping("/decorations")
    public List<Decoration> getDecoration() {
        return decorationService.getAllDecoration();
    }

    // 장식 고르기
    @PostMapping("/decorations/{decorationId}/users/{userId}")
    public ResponseEntity<String> chooseDeco(@PathVariable Long decorationId, @PathVariable Long userId) {
        decorationService.chooseDeco(userId, decorationId);
        return ResponseEntity.noContent().build();
    }

    // 장식 수정
    @PatchMapping("/decorations/{decorationId}/users/{userId}")
    public ResponseEntity<String> updateDeco(@PathVariable Long decorationId, @PathVariable Long userId, @RequestBody Decoration newDeco) {
        decorationService.updateDeco(userId, decorationId, newDeco);
        return ResponseEntity.noContent().build();
    }

    // 장식 옵션 보기
    @GetMapping("/decorations/{decorationId}/options")
    public List<Option> getOptions(@PathVariable Long decorationId) {
        return optionService.getOptions(decorationId);
    }

    // 장식 옵션 고르기
    @PostMapping("/decorations/{decorationId}/options/{optionId}/users/{userId}")
    public ResponseEntity<String> chooseOptions(@PathVariable Long decorationId, @PathVariable Long optionId, @PathVariable Long userId) {
        optionService.chooseOption(userId, decorationId, optionId);
        return ResponseEntity.noContent().build();
    }

    // 장식 옵션 수정
    @PatchMapping("/decorations/{decorationId}/users/{userId}/options/{optionId}")
    public ResponseEntity<String> updateOption(@PathVariable Long decorationId, @PathVariable Long userId, @PathVariable Long optionId, @RequestBody Option newOption) {
        optionService.updateOption(userId, decorationId, optionId, newOption);
        return ResponseEntity.noContent().build();
    }

    // 편지 작성
    @PostMapping("/users/{userId}/decorations/{decorationId}/letters")
    public ResponseEntity<Letter> createLetter(@PathVariable Long userId, @PathVariable Long decorationId, @RequestBody Letter letter) {
        Letter savedLetter = letterService.createLetter(userId, decorationId, letter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLetter);
    }
}



package com.example.tree.service;

import com.example.tree.model.Decoration;
import com.example.tree.repository.DecorationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecorationService {
    @Autowired
    private DecorationRepository decorationRepository;

    public List<Decoration> getAllDecorations() {
        return decorationRepository.findAll();
    }

    public void chooseDecoration(Long userId, Long decorationId) {
        // 장식 선택 로직
    }

}

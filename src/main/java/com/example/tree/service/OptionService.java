package com.example.tree.service;

import com.example.tree.model.Option;
import com.example.tree.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<Option> getOptionsByDecoration(Long decorationId) {
        return optionRepository.findByDecorationId(decorationId);
    }

    public void chooseOption(Long userId, Long decorationId, Long optionId) {
        // 옵션 선택 로직
    }
}

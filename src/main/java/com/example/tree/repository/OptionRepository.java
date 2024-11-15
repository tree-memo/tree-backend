package com.example.tree.repository;

import com.example.tree.model.Option;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByDecorationId(Long decorationId);
}
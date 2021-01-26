package com.github.thestyleofme.example.repository;

import com.github.thestyleofme.example.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description
 *
 * @author thestyleofme 2021/01/25 3:41 下午
 */
public interface PositionRepository extends JpaRepository<Position,Long> {
}

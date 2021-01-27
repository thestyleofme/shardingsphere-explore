package com.github.thestyleofme.example.repository;

import com.github.thestyleofme.example.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-26 16:47
 * @since 1.0.0
 */
public interface CityRepository extends JpaRepository<City, Long> {

}

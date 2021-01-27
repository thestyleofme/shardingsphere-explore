package com.github.thestyleofme.example.repository;

import com.github.thestyleofme.example.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-26 15:36:21
 * @since 1.0.0
 */
public interface PositionRepository extends JpaRepository<Position, Long> {

    /**
     * description
     *
     * @param id id
     * @return java.lang.Object
     */
    @Query(nativeQuery = true,
            value = "select p.id,p.city,p.name,p.salary,pd.description " +
                    "from position p join position_detail pd on p.id=pd.pid " +
                    "where p.id=:id")
    Object findPositionById(@Param("id") Long id);
}

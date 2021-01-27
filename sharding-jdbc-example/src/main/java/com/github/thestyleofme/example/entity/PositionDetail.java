package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-26 16:44:41
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "position_detail")
public class PositionDetail implements Serializable {

    private static final long serialVersionUID = 6991553493581411891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pid;
    private String description;

}

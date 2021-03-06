package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-26 16:44:33
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "position")
public class Position implements Serializable {

    private static final long serialVersionUID = -4562840864289148982L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String salary;
    private String city;

}

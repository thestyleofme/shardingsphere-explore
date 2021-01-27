package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-26 16:43
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 346974323861858586L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String province;
}

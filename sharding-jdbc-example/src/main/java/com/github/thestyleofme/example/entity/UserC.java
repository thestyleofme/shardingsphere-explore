package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-08 23:18
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "c_user")
@ToString
public class UserC implements Serializable {

    private static final long serialVersionUID = -3302597532829736883L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /**
     * 逻辑列名
     */
    @Column(name = "pwd")
    private String pwd;
}

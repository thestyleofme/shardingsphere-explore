package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * description
 *
 * @author thestyleofme 2021/01/25 3:09 下午
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

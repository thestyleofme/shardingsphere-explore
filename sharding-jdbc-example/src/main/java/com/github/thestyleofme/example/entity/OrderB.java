package com.github.thestyleofme.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-01-27 14:44:50
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "b_order")
public class OrderB implements Serializable {

    private static final long serialVersionUID = -163912789155849268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_del")
    private Boolean isDel;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "position_id")
    private Long positionId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "publish_user_id")
    private Integer publishUserId;
    @Column(name = "resume_type")
    private Integer resumeType;
    private String status;
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @Column(name = "operate_time")
    private LocalDateTime operateTime;
    @Column(name = "work_year")
    private String workYear;
    private String name;
    @Column(name = "position_name")
    private String positionName;
    @Column(name = "resume_id")
    private Integer resumeId;

}

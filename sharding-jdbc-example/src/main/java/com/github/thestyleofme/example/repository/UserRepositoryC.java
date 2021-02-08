package com.github.thestyleofme.example.repository;

import java.util.List;

import com.github.thestyleofme.example.entity.UserC;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-08 23:22
 * @since 1.0.0
 */
public interface UserRepositoryC extends JpaRepository<UserC, Long> {

    /**
     * description
     *
     * @param pwd 密码
     * @return List<UserC>
     */
    List<UserC> findByPwd(String pwd);
}

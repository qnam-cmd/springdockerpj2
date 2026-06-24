package org.spring.springdockerpj2.repository;

import org.spring.springdockerpj2.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByUserEmail(String userEmail);
}

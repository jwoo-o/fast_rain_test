package com.gen.api.entity.repository;

import com.gen.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member,String> {

    @Override
    @Modifying(clearAutomatically = true)
    @Query("delete from tb_member m where m.id = :id")
    void deleteById(String id);
}

package com.gen.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity(name = "tb_member")
public class Member implements Persistable<String> {

    @Id
    private String id;
    @Column
    private String password;

    @Builder
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void update(String password) {
        this.password = password;
    }


    @Override
    public boolean isNew() {
        return true;
    }
}

package com.bea.springbootmysql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@NoArgsConstructor
@Table(name="members")
public class Member {

    @Id
    private Long id;
    private String nickname;
    private String address;
    private Grade grade;

    public Member(String nickname, String address, Grade grade) {
        validateNickname(nickname);

        this.nickname = nickname;
        this.address = address;
        this.grade = grade;
    }

    public boolean isVIP() {
        return grade == Grade.VIP;
    }

    public void changeNickname(String nickname) {
        validateNickname(nickname);

        this.nickname = nickname;
    }

    private void validateNickname(String nickname) {
        int length = nickname.length();
        if (length < 3 || length > 10) {
            throw new IllegalArgumentException("닉네임은 3자이상 10자이하로 입력해주세요.");
        }
    }
}

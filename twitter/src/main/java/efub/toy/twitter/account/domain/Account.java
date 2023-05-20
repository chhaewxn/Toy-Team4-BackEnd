package efub.toy.twitter.account.domain;

import efub.toy.twitter.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static efub.toy.twitter.account.domain.AccountStatus.REGISTERED;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", updatable = false)
    private Long accountId;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private String encodedPassword;

    @Column(nullable = false, updatable = false, length = 16)
    private String nickname;
    private String bio;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Builder
    public Account(String email, String password, String nickname,
                   String bio) {

        this.email = email;
        this.encodedPassword = password;
        this.nickname = nickname;
        this.bio = bio;
        this.status = REGISTERED;
    }
}
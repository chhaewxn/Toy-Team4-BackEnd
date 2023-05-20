package efub.toy.twitter.tweet.domain;

import efub.toy.twitter.account.domain.Account;
import efub.toy.twitter.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Tweet extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId; // 카멜식 표기, mysql에서는 tweet_id
    @Column
    private String title;
    @Column(columnDefinition = "TEXT") // string이 아니라 text임을 명시
    private String content;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account writer; // tweet의 글 작성자이므로 변수명을 writer로

    @Builder
    public Tweet(Long tweetId, String title, String content, Account writer) {
        this.tweetId = tweetId;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
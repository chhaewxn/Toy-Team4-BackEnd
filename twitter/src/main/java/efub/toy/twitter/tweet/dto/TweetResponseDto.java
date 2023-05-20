package efub.toy.twitter.tweet.dto;

import efub.toy.twitter.tweet.domain.Tweet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetResponseDto {
    private Long tweetId;
    private String writerName;
    private String title;
    private String content;
    private LocalDateTime createdDate;

    public TweetResponseDto(Long tweetId, String writerName, String title, String content, LocalDateTime createdDate) {
        this.tweetId = tweetId;
        this.writerName = writerName;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    public static TweetResponseDto from(Tweet tweet) {
        return new TweetResponseDto(
                tweet.getTweetId(),
                tweet.getWriter().getNickname(),
                tweet.getTitle(),
                tweet.getContent(),
                tweet.getCreatedDate());
    }
}

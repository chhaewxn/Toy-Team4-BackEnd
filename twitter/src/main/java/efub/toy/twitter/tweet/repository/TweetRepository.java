package efub.toy.twitter.tweet.repository;

import efub.toy.twitter.account.domain.Account;
import efub.toy.twitter.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Optional<Tweet> findByTweetIdAndWriter_AccountId(Long tweetId, Long accountId);
    List<Tweet> findAllByWriter(Account writer);
}

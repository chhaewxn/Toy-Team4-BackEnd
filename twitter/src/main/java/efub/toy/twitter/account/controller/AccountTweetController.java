package efub.toy.twitter.account.controller;


// url: /accounts/{accountId}/tweets

import efub.toy.twitter.account.service.AccountService;
import efub.toy.twitter.tweet.domain.Tweet;
import efub.toy.twitter.tweet.dto.TweetListResponseDto;
import efub.toy.twitter.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/{accountId}/tweets")
@RequiredArgsConstructor
public class AccountTweetController {

    // 의존관계 : AccountTweetController -> PostService
    private final TweetService tweetService;
    // 의존관계 : AccountTweetController -> AccountService
    private final AccountService accountService;

    // 특정 유저의 게시글 목록 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TweetListResponseDto readAccountTweets(@PathVariable Long accountId) {
        List<Tweet> tweetList = tweetService.findTweetListByWriter(accountId);
        return TweetListResponseDto.of(tweetList);
    }


}

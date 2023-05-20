package efub.toy.twitter.account.dto;

import efub.toy.twitter.account.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String username;
    private String userId;

    public AccountResponseDto(Long accountId, String username, String userId) {
        this.accountId = accountId;
        this.username = username;
        this.userId = userId;
    }
    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(
                account.getAccountId(),
                account.getUsername(),
                account.getUserId());
    }
}
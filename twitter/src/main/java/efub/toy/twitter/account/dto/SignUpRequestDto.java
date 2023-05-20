package efub.toy.twitter.account.dto;

import efub.toy.twitter.account.domain.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDto {
    @NotBlank(message = "비밀번호는 필수입니다.")//해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!.?,])[A-Za-z\\d!.?,]{2,16}$",
            message = "16자 이내의 영문자 및 숫자와 ?,!,., , 특수문자로 입력해주세요.")
    private String password;

    @NotBlank(message = "유저이름(ex.채원)은 필수입니다. ")//해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    private String username;

    @NotBlank(message = "유저아이디(ex.@chhaewxn)은 필수입니다. ")//해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    private String userId;

    @Builder
    public SignUpRequestDto(String password, String username, String userId) {
        this.password = password;
        this.username = username;
        this.userId = userId;
    }

    public Account toEntity() {
        return Account.builder()
                .password(this.password)
                .username(this.username)
                .userId(this.userId)
                .build();
    }
}
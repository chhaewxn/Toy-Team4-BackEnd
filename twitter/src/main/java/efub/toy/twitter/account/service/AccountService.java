package efub.toy.twitter.account.service;

import efub.toy.twitter.account.domain.Account;
import efub.toy.twitter.account.dto.SignUpRequestDto;
import efub.toy.twitter.account.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    public Long signUp(SignUpRequestDto requestDto){
        if (existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("이미 존재하는 email입니다. " + requestDto.getEmail());
        }
        Account account = accountRepository.save(requestDto.toEntity());
        return account.getAccountId();
    }

    @Transactional(readOnly = true)
    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id 를 가진 Account 를 찾을 수 없습니다. id ="+id));
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email){
        return accountRepository.existsByEmail(email);
    }
}

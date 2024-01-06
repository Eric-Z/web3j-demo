package eric.beta.web3j.sample;

import eric.beta.web3j.dtp.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountSample {

    private final Admin admin;

    public List<AccountDTO> list() throws IOException {
        PersonalListAccounts personalListAccounts = admin.personalListAccounts().send();
        return personalListAccounts.getAccountIds().stream()
                .map(v -> AccountDTO.builder()
                        .id(v)
                        .build()
                )
                .collect(Collectors.toList());
    }

    public AccountDTO add(AccountDTO accountDTO) throws IOException {
        NewAccountIdentifier newAccountIdentifier = admin.personalNewAccount(accountDTO.getPassword()).send();
        return AccountDTO.builder()
                .id(newAccountIdentifier.getAccountId())
                .password(accountDTO.getPassword())
                .build();
    }
}

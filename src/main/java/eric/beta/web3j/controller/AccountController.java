package eric.beta.web3j.controller;

import eric.beta.web3j.dtp.AccountDTO;
import eric.beta.web3j.sample.AccountSample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountSample accountSample;

    @GetMapping("/accounts")
    public List<AccountDTO> list() throws IOException {
        return accountSample.list();
    }

    @PostMapping("/accounts")
    public AccountDTO add(@RequestBody AccountDTO accountDTO) throws IOException {
        return accountSample.add(accountDTO);
    }
}

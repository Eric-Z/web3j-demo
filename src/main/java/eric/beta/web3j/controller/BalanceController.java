package eric.beta.web3j.controller;

import eric.beta.web3j.sample.BalanceSample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceSample balanceSample;

    @GetMapping("/balances")
    public BigInteger get(@RequestParam(value = "address") String address) throws Exception {
        return balanceSample.get(address);
    }
}

package eric.beta.web3j.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

import java.io.IOException;
import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class BalanceSample {

    private final Web3j web3j;

    public BigInteger get(String address) throws IOException {
        EthGetBalance ethGetBalance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        return ethGetBalance.getBalance();
    }
}

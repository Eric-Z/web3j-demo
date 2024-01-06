package eric.beta.web3j.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ConnectionSample {

    private final Web3j web3j;

    public String getClientVersion() throws IOException {
        String clientVersion = web3j.web3ClientVersion().send().getWeb3ClientVersion();
        return "web3j client version:" + clientVersion;
    }
}

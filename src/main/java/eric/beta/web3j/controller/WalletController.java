package eric.beta.web3j.controller;

import eric.beta.web3j.dto.WalletDTO;
import eric.beta.web3j.sample.WalletSample;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletSample walletSample;

    @PostMapping("/wallets")
    public WalletDTO add(@RequestBody WalletDTO walletDTO) throws Exception {
        return walletSample.add(walletDTO);
    }

    @PostMapping("/wallets/qr-code")
    public void addAndReturnQrCode(HttpServletResponse response, @RequestBody WalletDTO walletDTO) throws Exception {
        walletSample.addAndReturnQRCode(response, walletDTO);
    }
}

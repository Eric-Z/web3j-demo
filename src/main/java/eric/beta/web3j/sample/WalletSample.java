package eric.beta.web3j.sample;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import eric.beta.web3j.dto.WalletDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WalletSample {

    private static final String PREDIX = "0x";

    public WalletDTO add(WalletDTO walletDTO) throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        WalletFile walletFile = Wallet.createStandard(walletDTO.getPassword(), ecKeyPair);
        return WalletDTO.builder()
                .address(PREDIX + walletFile.getAddress())
                .password(walletDTO.getPassword())
                .privateKey(ecKeyPair.getPrivateKey().toString(16))
                .publicKey(ecKeyPair.getPublicKey().toString(16))
                .build();
    }

    public void addAndReturnQRCode(HttpServletResponse response, WalletDTO walletDTO) throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        Wallet.createStandard(walletDTO.getPassword(), ecKeyPair);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(ecKeyPair.getPrivateKey().toString(16), BarcodeFormat.QR_CODE, 256, 256, hints);

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        response.setContentType("image/png");
        ImageIO.write(bufferedImage, "png", response.getOutputStream());
    }
}

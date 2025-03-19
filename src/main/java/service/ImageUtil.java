package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {

    public byte[] convertToByteArray(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }
    public String convertToBase64(byte[] photo) {
        return Base64.getEncoder().encodeToString(photo);
    }
}

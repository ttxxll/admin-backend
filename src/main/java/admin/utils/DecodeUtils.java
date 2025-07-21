package admin.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Slf4j
public class DecodeUtils {

    public static String decodeUrl(String encode) {
        try {
            return URLDecoder.decode(encode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("decodeUrl error! encode = {}", encode, e);
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(DecodeUtils.decodeUrl("%E4%BC%8D*%E9%B9%8F"));;
        System.out.println(DecodeUtils.decodeUrl("%E6%9D%8E*%E5%AE%BE"));;
    }
}

package com.tosspayments.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingUtils {
    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static void encodeBlock(byte[] src, int sp, int sl, byte[] dst, int dp) {
        char[] base64 = toBase64;
        for (int sp0 = sp, dp0 = dp; sp0 < sl; ) {
            int bits = (src[sp0++] & 0xff) << 16 |
                    (src[sp0++] & 0xff) << 8 |
                    (src[sp0++] & 0xff);
            dst[dp0++] = (byte) base64[(bits >>> 18) & 0x3f];
            dst[dp0++] = (byte) base64[(bits >>> 12) & 0x3f];
            dst[dp0++] = (byte) base64[(bits >>> 6) & 0x3f];
            dst[dp0++] = (byte) base64[bits & 0x3f];
        }
    }

    private static int encode0(byte[] src, int off, int end, byte[] dst) {
        char[] base64 = toBase64;
        int sp = off;
        int slen = (end - off) / 3 * 3;
        int sl = off + slen;
        int dp = 0;

        while (sp < sl) {
            int sl0 = Math.min(sp + slen, sl);
            encodeBlock(src, sp, sl0, dst, dp);
            int dlen = (sl0 - sp) / 3 * 4;
            dp += dlen;
            sp = sl0;
        }
        if (sp < end) {
            int b0 = src[sp++] & 0xff;
            dst[dp++] = (byte) base64[b0 >> 2];
            if (sp == end) {
                dst[dp++] = (byte) base64[(b0 << 4) & 0x3f];
                dst[dp++] = '=';
                dst[dp++] = '=';
            } else {
                int b1 = src[sp++] & 0xff;
                dst[dp++] = (byte) base64[(b0 << 4) & 0x3f | (b1 >> 4)];
                dst[dp++] = (byte) base64[(b1 << 2) & 0x3f];
                dst[dp++] = '=';
            }
        }
        return dp;
    }

    private static int outLength(int srclen) {
        return 4 * ((srclen + 2) / 3);
    }

    private static byte[] encode(byte[] src) {
        int len = outLength(src.length);          // dst array size
        byte[] dst = new byte[len];
        int ret = encode0(src, 0, src.length, dst);
        if (ret != dst.length)
            return Arrays.copyOf(dst, ret);
        return dst;
    }

    public static String encodeBase64(String data) throws UnsupportedEncodingException {
        byte[] encoded = encode(data.getBytes("UTF-8"));
        return new String(encoded, 0, encoded.length);
    }
}

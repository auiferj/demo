package com.example.sm4;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

import java.security.SecureRandom;
import java.util.Base64;

public class SM4KeyGenerator {
    public static void main(String[] args) {
        // 生成 SM4 密钥
        byte[] sm4Key = generateSM4Key();
        // 输出密钥
        System.out.println("SM4 Key (Hex): " + bytesToHex(sm4Key));
        System.out.println("SM4 Key (Base64): " + Base64.getEncoder().encodeToString(sm4Key));
    }

    /**
     * 生成一个 128 位（16 字节）的 SM4 密钥
     *
     * @return SM4 密钥
     */
    public static byte[] generateSM4Key() {
        // 使用 Bouncy Castle 的 CipherKeyGenerator 生成密钥
        CipherKeyGenerator keyGen = new CipherKeyGenerator();
        // 初始化随机数和密钥长度（128 位）
        keyGen.init(new KeyGenerationParameters(new SecureRandom(), 128));
        return keyGen.generateKey();
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}

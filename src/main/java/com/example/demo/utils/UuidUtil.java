package com.example.demo.utils;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * id生成器
 *
 * @author March
 * @date 2020/7/10
 */
public class UuidUtil {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static String[] chars2 = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static final Object PRESENT = new Object();

    public static void main(String[] args) {

        Long number = new Long("26915052");



        for (int i = 0; i < 1000; i++) {

            new Thread( () -> {
                ConcurrentHashMap<Long, Long> map = new ConcurrentHashMap<>();
               for (;;) {
                   Long numberUuid = getNumberUuid();
                   System.out.println(numberUuid);
                   boolean repeatFlag = !(map.put(numberUuid, number) == null);
                   System.out.println(Thread.currentThread().getName() + ": map长度：" + map.size());
                   if (repeatFlag) {
                       System.out.println(Thread.currentThread().getName() + ": map长度：" + map.size());
                       throw new RuntimeException("重复了");
                   }
               }
            }).start();
        }


    }


    /**
     * <h2>获取8为唯一ID</h2>
     * @return {@link String } eight digits unique ID
     */
    public static Long getNumberUuid() {

        StringBuilder shortBuilder = new StringBuilder();
        String uuid = UuidUtil.getUuid();
        for (int i = 0; i < 16; i++) {
            String str = uuid.substring(i * 2 , i * 2 + 2);
            int x = Integer.parseInt(str, 16);
            shortBuilder.append(chars2[x % 0xA]); // 对10取余
        }
        return  Long.parseLong(shortBuilder.toString());

    }

    /**
     * <h2>获取8为唯一ID</h2>
     * @return {@link String } eight digits unique ID
     */
    public static String getShortUuid() {

        StringBuilder shortBuilder = new StringBuilder();
        String uuid = UuidUtil.getUuid();
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
             shortBuilder.append(chars[x % 0x3E]); // 对62取余
        }
        return  shortBuilder.toString();

    }

    /**
     * 获得32位UUID
     */
    public static String getUuid(){

        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

}

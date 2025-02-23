package com.nageoffer.shortlink.admin.test;


public class UserTableShardingTest {
    private static final String SQL = "ALTER TABLE `link`.`t_link_%d` \n" +
            "ADD COLUMN `favicon` varchar(255) NULL COMMENT '网站图标' AFTER `gid`;";

    public static void main(String[] args) {
        for (int i = 0; i < 16; ++i) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}

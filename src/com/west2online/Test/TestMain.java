package com.west2online.Test;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        int optional;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            optional = scanner.nextInt();
            switch (optional) {
                case 0:
                    GOTO outer;
                    break;
                case 1:
                    Insert.insert();
                    break;
                case 2:
                    Delete.delete();
                    break;
                case 3:
                    Update.update();
                    break;
                case 4:
                    Select.select();
                    break;
                default:
                    System.out.print("请输入合法值！");
                    break;
            }
        }
        outer:
        return;

//        Insert.insert();
//        Delete.delete();
//        Update.update();
//        Select.select();
    }


    static void menu() {
        System.out.println("=============================");
        System.out.println("欢迎进入订单管理系统");
        System.out.println("1.记录新的订单");
        System.out.println("2.删除旧的订单");
        System.out.println("3.更改订单内容");
        System.out.println("4.查询订单信息");
        System.out.println("0.退出订单管理系统");
        System.out.println("=============================");
        System.out.print("请键入:");
    }





}

package com.study.effectivejava.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryCatchExample {

//    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = null;
//        BufferedInputStream bufferedInputStream = null;
//
//        try {
//            fileInputStream = new FileInputStream("test.txt");
//            bufferedInputStream = new BufferedInputStream(fileInputStream);
//
//            int i = -1;
//            while ((i = bufferedInputStream.read()) != -1) {
//                System.out.print((char) i);
//            }
//
//        } catch (IOException e) {
//            //log.error(e);
//        } finally {
//            if (bufferedInputStream != null) {
//                bufferedInputStream.close();
//            }
//            if (fileInputStream != null) {
//                fileInputStream.close();
//            }
//        }
//    }


    public static void main(String[] args) throws Exception {
        CustomResource customResource = null;

        try {
            customResource = new CustomResource();
            customResource.doSomething();
        } finally {
            if (customResource != null) {
                customResource.close();
            }
        }
    }
}

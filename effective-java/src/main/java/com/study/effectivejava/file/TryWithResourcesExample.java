package com.study.effectivejava.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        try (CustomResource customResource = new CustomResource()) {
            customResource.doSomething();
        } catch (IOException e) {
            //log.error(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

//    public static void main(String[] args) {
//        try (FileInputStream fileInputStream = new FileInputStream("test.txt");
//             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)
//        ) {
//            int i = -1;
//            while ((i = bufferedInputStream.read()) != -1) {
//                System.out.print((char) i);
//            }
//        } catch (IOException e) {
//            //log.error(e);
//        }
//    }
//}

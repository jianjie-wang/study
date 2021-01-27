package com.example.study.practice;

import org.springframework.util.StopWatch;

import java.io.*;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2021-01-22 15:33
 **/
public class FileTest {

    public static void main(String[] args) throws IOException {
        //是获取系统临时目录。可以是window的temp，linux的临时目录等
        String destPath = System.getProperty("java.io.tmpdir");
        System.out.println(destPath);
        System.out.println(File.separator);

//        readFile();
        StopWatch stopWatch = new StopWatch("复制文件");
        stopWatch.start("一个字节一个字节的复制");
        fun();
        stopWatch.stop();

        stopWatch.start("1024字节数组复制");
        fun1();
        stopWatch.stop();

        stopWatch.start("一个字节一个字节复制，并使用缓冲流");
        fun2();
        stopWatch.stop();

        stopWatch.start("1024字节数组复制，并用缓冲流");
        fun3();
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

    public static void readFile() {
        //先把文件读到内存，然后写入到文件类里
        File file = new File("C:\\Users\\WJJ\\Desktop\\mima.txt");
        //File没有读写能力，所以需要FileInputStream文件输入流
        FileInputStream is = null;
        {
            try {
                //也可以直接从文件夹读取
                //is = new FileInputStream("C:\\Users\\WJJ\\Desktop\\mima.txt");
                is = new FileInputStream(file);

                //定义一个字节数组，相当于缓存
                byte[] bytes = new byte[1024];
                System.out.println(bytes.length);
                int n = 0;
                //读取完毕返回读入缓冲区的字节总数,读取失败返回-1
                while ((n = is.read(bytes)) != -1) {
                    //把字节转成String，从0到n变成String
                    String s = new String(bytes, 0, n);
                    System.out.println(bytes.length);
                    System.out.println(s);
                    System.out.println(n + "------------------------------");
                }

                OutputStream outputStream = null;
                outputStream.write(bytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //最后一定要关闭文件流
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void writeFile() {

    }


    //一个字节一个字节的复制，耗时22697毫秒
    public static void fun() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\WJJ\\Desktop\\kkk.docx");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\WJJ\\Desktop\\复制\\01\\fff.docx");
        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    //1024字节数组复制 耗时63毫秒
    public static void fun1() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\WJJ\\Desktop\\kkk.docx");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\WJJ\\Desktop\\复制\\02\\fff.docx");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();
    }

    // 一个字节一个字节复制，但是用了缓冲流 耗时64毫秒
    public static void fun2() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\WJJ\\Desktop\\kkk.docx"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\WJJ\\Desktop\\复制\\03\\fff.docx"));
        int by = 0;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();
    }


    // 1024字节数组复制并用了缓冲流 耗时7毫秒
    public static void fun3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\WJJ\\Desktop\\kkk.docx"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\WJJ\\Desktop\\复制\\04\\fff.docx"));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }


}

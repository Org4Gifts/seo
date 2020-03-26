package com.adima.seo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author 夕橘子-O
 * https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/316275/
 * @version 2016年7月8日 上午10:38:49
 */
public class ForFile {
//生成檔案路徑

    private static String path = "D:\\file\\";
//檔案路徑 名稱
    private static String filenameTemp;

    /**
     * 建立檔案
     *
     * @param fileName 檔名稱
     * @param filecontent 檔案內容
     * @return 是否建立成功，成功則返回true
     */
    public static boolean createFile(String fileName, String filecontent) {
        if(getOperatingSystem().equals("Mac OS X"))
            path = "/Users/odise/workspace/";
            
        Boolean bool = false;
        filenameTemp = path + fileName + ".txt";//檔案路徑 名稱 檔案型別
        File file = new File(filenameTemp);
        try {
//如果檔案不存在，則建立新的檔案
            if (!file.exists()) {
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is " + filenameTemp);
//建立檔案成功後，寫入內容到檔案裡
                writeFileContent(filenameTemp, filecontent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * 向檔案中寫入內容
     *
     * @param filepath 檔案路徑與名稱
     * @param newstr 寫入的內容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath, String newstr) throws IOException {
        Boolean bool = false;
        String filein = newstr + "\r\n";//新寫入的行，換行
        String temp = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//檔案路徑(包括檔名稱)
//將檔案讀入輸入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
//檔案原有內容
            for (int i = 0; (temp = br.readLine()) != null; i++) {
                buffer.append(temp);
// 行與行之間的分隔符 相當於“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
// TODO: handle exception
            e.printStackTrace();
        } finally {
//不要忘記關閉
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }

    /**
     * 刪除檔案
     *
     * @param fileName 檔名稱
     * @return
     */
    public static boolean delFile(String fileName) {
        Boolean bool = false;
        filenameTemp = path + fileName + ".txt";
        File file = new File(filenameTemp);
        try {
            if (file.exists()) {
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
// TODO: handle exception
        }
        return bool;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        createFile(uuid + "myfile", "我的夢說別停留等待,就讓光芒折射淚溼的瞳孔,映出心中最想擁有的彩虹,帶我奔向那片有你的天空,因為你是我的夢 我的夢");
        System.out.println("os: "+getOperatingSystem());
    }
    
    public static String getOperatingSystem() {
    String os = System.getProperty("os.name");
    // System.out.println("Using System Property: " + os);
    return os;
}
}

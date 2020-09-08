package com.example.study.service.string;

import com.example.study.service.DTO.VxcpTagVM;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-10 14:21
 **/
@Service
public class StringSplitService {
    private static final Logger log = LoggerFactory.getLogger(StringSplitService.class);

    //完整获取中国地区IP
    public List<String> jie() {
        String ipUrl = "http://ftp.apnic.net/apnic/stats/apnic/delegated-apnic-latest";
        String ip = this.get(ipUrl);
        if (StringUtils.isBlank(ip)) return null;

        String[] lists = ip.split("\n");
        List<String> list= new ArrayList<>();
//        try {
            for (String str:lists) {
                if (str.startsWith("apnic") && str.contains("|CN|ipv4|")){
                    String a[] = str.split("\\|");
                    list.add(a[3]);
                }
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return list;
    }
    //HttpURLConnection获取中国地区IP
    public String dididi() {
        Map<String,String> map = request("http://ftp.apnic.net/apnic/stats/apnic/delegated-apnic-latest");
        String s = parseOnline(map.get("result"));
        return s;
    }

    public void load() {
        // 假设有一串字符串 96558&JQKA
        String asd = "96528&JQKA";
        // 想让它以&符号分离
        String[] sp = asd.split("&");
        // 直接输出该数组
        System.out.println("直接输出数组：" + sp);           //直接输出数组：[Ljava.lang.String;@2b9627bc
        // toString一下
        String dString = sp.toString();
        // 再输出
        System.out.println("toString输出数组：" + dString); // toString输出数组：[Ljava.lang.String;@2b9627bc
        // 用这转一下再输出(...源码其实就是循环数组再拼成一个字符串......)
        System.err.println("啦啦啦" + Arrays.toString(sp));// 啦啦啦[96528, JQKA]
        // 指定位置截取。1,3简单表示：1表示下标为1开始截取(数组下标从0开始)0,3表示下标为3结束。
        String string = asd.substring(1, 3);
        // 输出
        System.out.println("分离sub:" + string);    //分离sub:65
        System.err.println("数组长度" + sp.length); //数组长度2
        for (int i = 0; i < sp.length; i++) {
            System.err.println("第" + (i + 1) + "个:" + sp[i]);
        }
//        第1个:96528
//        第2个:JQKA

    }

    //拼接字符串
    public void pinjieString(){
        List<String> strings = new ArrayList<>();
        for (int i=0; i <= 20; i++){
            strings.add("字符串"+i);
        }
        System.out.println("原始集合:"+strings);
        String touser = strings.stream().collect(Collectors.joining("|"));
        System.out.println("拼接后:"+touser);
    }
//    原始集合:[字符串0, 字符串1, 字符串2, 字符串3, 字符串4, 字符串5, 字符串6, 字符串7, 字符串8, 字符串9, 字符串10, 字符串11, 字符串12, 字符串13, 字符串14, 字符串15, 字符串16, 字符串17, 字符串18, 字符串19, 字符串20]
//    拼接后:字符串0|字符串1|字符串2|字符串3|字符串4|字符串5|字符串6|字符串7|字符串8|字符串9|字符串10|字符串11|字符串12|字符串13|字符串14|字符串15|字符串16|字符串17|字符串18|字符串19|字符串20


    private static String parseOnline(String str1){
        String lists[] = str1.split("\n");
        StringBuilder sb = new StringBuilder();
        try {
            for (String str:lists) {
                if (str.startsWith("apnic") && str.contains("|CN|ipv4|")){
                    String a[] = str.split("\\|");
                    Integer mask = 32-(int)(Math.log(Double.valueOf(a[4]))/Math.log(2));
                    sb.append(a[3]).append("/").append(mask).append('\n');
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



    private static Map<String,String> request(String url) {
        Map<String,String> response = new HashMap<String, String>();
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //设置请求方式
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            response.put("code",responseCode + "");
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while((inputLine = in.readLine())!=null){
                    responseBuffer.append(inputLine).append("\n");
                }
                in.close();
                response.put("result",responseBuffer.toString());
            }else{
                response.put("result","");
            }
        }catch (Exception e){
            response.put("result","failed");
        }
        return response;
    }




    public static String get(String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            try (
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpClient.execute(httpGet)
            ) {
                HttpEntity entity = (HttpEntity) response.getEntity();
                if (entity != null) {
                    String str = EntityUtils.toString((org.apache.http.HttpEntity) entity, "UTF-8");
                    return str;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        VxcpTagVM vxcpTagVM = new VxcpTagVM();
        vxcpTagVM.setGroupId(new String[]{"dfdfdf", "gfdfdf"});
        System.out.println(Arrays.toString(vxcpTagVM.getGroupId()));

        String[] s = vxcpTagVM.getGroupId();
        System.out.println(s);
    }


}

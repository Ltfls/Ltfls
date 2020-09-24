package main;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.*;
import java.util.*;

/**
 * @Description 1. 利用 IO 流读入文本
 *              2. 把读入的文本转化成 String 类型
 *              3. 利用 IK 算法对文本进行分词，并写入到集合 List中
 *              4. 遍历 List 把每一个词放进 HashMap 中，并查看 key 是否相同，若相同则 value + 1 否则则放入新的位置，以此计算出词频
 *              5. 根据余弦定理计算余弦相似度
 *              6. 最后把结果输出到
 * @Author Ling
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/24
 */

public class TextProcessor {
    int[] temp = null;
    Map<String, int[]> checkMap = new HashMap<String, int[]>();


    public void inMap(String address1,String address2) throws Exception {//压入 HashMap 中并计算每个词语出现的频率

        List<String> words1 = spilt(change(address1));
        List<String> words2 = spilt(change(address2));
        for (int i = 0; i < words1.size(); i++) {
            if (checkMap.containsKey(words1.get(i))) {
                checkMap.get(words1.get(i))[0]++;
            } else {
                temp = new int[2];
                temp[0] = 1;
                temp[1] = 0;
                checkMap.put(words1.get(i), temp);
            }
        }

        for (int i = 0; i < words2.size(); i++) {
            if (checkMap.containsKey(words2.get(i))) {
                checkMap.get(words2.get(i))[1]++;
            } else {
                temp = new int[2];
                temp[0] = 0;
                temp[1] = 1;
                checkMap.put(words2.get(i), temp);
            }
        }

    }


    public static String change(String address) throws IOException {//读入文本并把里面的内容转化为String

        StringBuffer buffer=new StringBuffer();
        String s=null;
        BufferedReader bf=new BufferedReader(new FileReader(address));
        while((s=bf.readLine())!=null){
            buffer.append(s.trim());
        }
        String str=buffer.toString();
        String string=str.replaceAll("\\s*","");//除去字符串中所有空格和换行。
        return string;

    }
    public static List<String> spilt(String text) throws Exception {//运用ik算法进行分词

        Lexeme lexeme = null;
        StringReader stringReader=new StringReader(text);

        IKSegmenter ikSegmenter=new IKSegmenter(stringReader,true);
        List<String> list = new ArrayList<String>();
        try {
            while ((lexeme = ikSegmenter.next()) != null) {
                list.add(lexeme.getLexemeText());
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return list;

    }
    public  void outPut(double sim,String outAddress) throws IOException {//写出文件
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        File file = new File(new File(outAddress).getParent()+"\\answer.txt");
        fos = new FileOutputStream(file);
        osw = new OutputStreamWriter(fos);
        double result=sim;
        osw.write("重复率为： "+result);
        osw.flush();
        osw.close();
        fos.close();

    }
    public Map<String, int[]> getMap(){//获取 HashMap
        return checkMap;
    }


}

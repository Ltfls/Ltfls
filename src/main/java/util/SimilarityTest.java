package util;


import main.TextProcessor;
import org.junit.Test;


/**
 * @Description
 * @Author Ling
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/24
 */

public class SimilarityTest {


    @Test
    public void test1() throws Exception {//orig.txt 与 orig_0.8_add 比较，结果为： 0.9779183058420126
        TextProcessor papers = new TextProcessor();
        papers.inMap("C:\\Users\\Crazy宇\\Desktop\\test\\orig.txt","C:\\Users\\Crazy宇\\Desktop\\test\\orig_0.8_add.txt");
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,"C:\\Users\\Crazy宇\\Desktop\\test\\answer.txt");
        System.out.println(result);

}
    @Test
    public void test2() throws Exception {//orig.txt 与 orig_0.8_del 比较，结果为： 0.9841263644151691
        TextProcessor papers = new TextProcessor();
        papers.inMap("C:\\Users\\Crazy宇\\Desktop\\test\\orig.txt","C:\\Users\\Crazy宇\\Desktop\\test\\orig_0.8_del.txt");
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,"C:\\Users\\Crazy宇\\Desktop\\test\\answer.txt");
        System.out.println(result);

    }
    @Test
    public void test3() throws Exception {//orig.txt 与 orig_0.8_dis_1 比较，结果为： 0.9958668236739756
        TextProcessor papers = new TextProcessor();
        papers.inMap("C:\\Users\\Crazy宇\\Desktop\\test\\orig.txt","C:\\Users\\Crazy宇\\Desktop\\test\\orig_0.8_dis_1.txt");
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,"C:\\Users\\Crazy宇\\Desktop\\test\\answer.txt");
        System.out.println(result);

    }
    @Test
    public void test4() throws Exception {//orig.txt 与 orig_0.8_dis_10 比较，结果为： 0.9809672446816522
        TextProcessor papers = new TextProcessor();
        papers.inMap("C:\\Users\\Crazy宇\\Desktop\\test\\orig.txt","C:\\Users\\Crazy宇\\Desktop\\test\\orig_0.8_dis_10.txt");
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,"C:\\Users\\Crazy宇\\Desktop\\test\\answer.txt");
        System.out.println(result);

    }
    @Test
    public void test5() throws Exception {//orig.txt 与 orig_0.8_dis_15 比较，结果为： 0.9437293625155243
        TextProcessor papers = new TextProcessor();
        papers.inMap("C:\\Users\\Crazy宇\\Desktop\\test\\orig.txt","C:\\Users\\Crazy宇\\Desktop\\test\\orig_0.8_dis_15.txt");
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,"C:\\Users\\Crazy宇\\Desktop\\test\\answer.txt");
        System.out.println(result);

    }
}

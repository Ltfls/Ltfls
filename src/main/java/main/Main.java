package main;

import util.Algorithm;

/**
 * @Description
 * @Author Ling
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/24
 */

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length<3){
            System.out.println("请输入正确的命令行参数");
            System.exit(0);
        }

        TextProcessor papers = new TextProcessor();
        papers.inMap(args[0],args[1]);
        Algorithm al = new Algorithm();
        double result=al.sim(papers.getMap());
        papers.outPut(result,args[2]);
        System.out.println(result);


    }
}

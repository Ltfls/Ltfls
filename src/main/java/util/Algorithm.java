package util;

import java.util.Map;
import java.util.Set;

/**
 * @Description 计算余弦相似度的工具类
 * @Author Ling
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/24
 */

public class Algorithm {
    public double sim(Map<String, int[]> checkMap) {// 求余弦相似度
        double result = 0;
        result = point(checkMap) / sqrtMulti(checkMap);

        return result;
    }

    private double sqrtMulti(Map<String, int[]> checkMap) {//求开方
        double result = 0;
        result = squares(checkMap);
        result = Math.sqrt(result);
        return result;
    }
    private double point(Map<String, int[]> checkMap) {// 点乘法
        double result = 0;
        for (String key :checkMap.keySet()) {
            int temp[] = checkMap.get(key);
            result += (temp[0] * temp[1]);
        }
        return result;
    }

    private double squares(Map<String, int[]> checkMap) { // 求平方和
        double result1 = 0;
        double result2 = 0;
        Set<String> keySet = checkMap.keySet(); //把每个 key 后的 value 的平方相乘
        for (String key : keySet) {
            int temp[] = checkMap.get(key);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }
}

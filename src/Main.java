import entity.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Peize Li
 * 创建牌堆：
 * 使用 ArrayList<Card> 创建一个空集合 cardList 来存放所有的牌。
 * 使用两个嵌套循环来创建一副完整的扑克牌。外层循环负责牌面值，内层循环负责四种花色。
 * 根据不同的牌面值设置 num 字符串（1至10，J，Q，K）。
 * 内层循环设置 kind 字符串（梅花、黑桃、方块、红桃），并创建新的 Card 对象添加到 cardList 中。
 * 洗牌：
 * 使用 Random 类生成随机数。
 * 将 cardList 转换成 Object[] 数组 arr。
 * 使用 Fisher-Yates 洗牌算法对数组进行随机排序。
 * 分配手牌：
 * 创建四个 ArrayList<Card> 来分别存储四位玩家的手牌。
 * 使用 for 循环遍历洗好后的牌数组 arr，根据索引值分配给不同的玩家。
 * 输出结果：
 * 打印每位玩家的手牌列表。
 * 注意事项：
 * 使用 Card 类构造函数 Card(String num, String kind)，用于创建牌对象。
 * (Card) arr[i] 是强制类型转换。
 */

public class Main {
    public static void main(String[] args) {
        // 创建一个ArrayList来存储所有52张扑克牌对象
        ArrayList<Card> cardList = new ArrayList<>();

        // 初始化牌号字符串变量
        String num = "0";
        // 初始化花色字符串变量
        String kind = null;

        // 循环创建13种不同数字/字母的牌（从1到K）
        for (int i = 0; i < 13; i++) {
            // 根据牌的种类设置牌号
            if (i < 10) {
                num = String.valueOf(i + 1); // 数字牌，如1-9
            } else if (i == 10) {
                num = "J"; // Jack
            } else if (i == 11) {
                num = "Q"; // Queen
            } else {
                num = "K"; // King
            }

            // 对每种牌号创建四种花色的牌
            for (int j = 0; j < 4; j++) {
                // 设置花色
                if (j == 0) {
                    kind = "梅花";
                } else if (j == 1) {
                    kind = "黑桃";
                } else if (j == 2) {
                    kind = "方块";
                } else {
                    kind = "红桃";
                }
                // 创建一张牌并添加到列表中
                cardList.add(new Card(num, kind));
            }
        }

        // 创建随机数生成器
        Random random = new Random();

        // 将牌列表转换为数组，使用object数组接收,并进行洗牌操作
        Object[] arr = cardList.toArray();
        for (int i = arr.length - 1; i > 0; i--) {
            // 随机选择一个索引位置
            int j = random.nextInt(i + 1);
            // 交换当前索引的牌与随机索引的牌
            Object temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        // 创建四个玩家的手牌列表
        ArrayList<Card> person1 = new ArrayList<>();
        ArrayList<Card> person2 = new ArrayList<>();
        ArrayList<Card> person3 = new ArrayList<>();
        ArrayList<Card> person4 = new ArrayList<>();

        // 分配牌给四个玩家
        // 强制类型转换
        for (int i = 0; i < arr.length; i++) {
            if (i % 4 == 0) {
                person1.add((Card) arr[i]); // 第一个玩家拿牌
            } else if (i % 4 == 1) {
                person2.add((Card) arr[i]); // 第二个玩家拿牌
            } else if (i % 4 == 2) {
                person3.add((Card) arr[i]); // 第三个玩家拿牌
            } else {
                person4.add((Card) arr[i]); // 第四个玩家拿牌
            }
        }

        // 输出每个玩家的手牌
        System.out.println("Player 1: " + person1);
        System.out.println("Player 2: " + person2);
        System.out.println("Player 3: " + person3);
        System.out.println("Player 4: " + person4);
    }
}


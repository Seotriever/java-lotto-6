package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String coin = Console.readLine();
        int coinInput = Integer.parseInt(coin);
        purchaseLotto(coinInput);

    }
    public static void purchaseLotto(int coinInput) {
        for (int i=0;i<coinInput;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);    //로또 확인값
        }
    }
}

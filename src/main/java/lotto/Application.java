package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Application {
        public static void main(String[] args) {
                // TODO: 프로그램 구현
                // TODO 추후 Coin 클래스 or 메소드로 구현
                // TODO 주요 기능마다 테스트 코드 작성
                int coin = inputCoin();
                List<Lotto> lottoList = toChangeLotto(coin);
        }

        public static int inputCoin() {
                System.out.println("구입금액을 입력해 주세요.");   //구입 금액 입력
                int coin = 0;
                while (true) {
                        String coinInput = Console.readLine();
                        if (validCoinInput(coinInput)) {
                                coin = Integer.parseInt(coinInput) / 1000;
                                return coin;
                        }
                        System.out.println("[ERROR] 1000원 단위로 다시 입력해 주세요.");
                }
        }


        public static boolean validCoinInput(String coinInput) {
                int coin;
                try {
                        coin = Integer.parseInt(coinInput);
                        if (coin % 1000 != 0 || coin < 0) {
                                return false;
                        }
                } catch (IllegalArgumentException e) {
                        return false;
                }
                return true;
        }

        public static List<Lotto> toChangeLotto(int coin) {    //받은 로또
                List<Lotto> lottoList = new ArrayList<>();
                System.out.println("\n"+coin + "개를 구매했습니다.");
                for (int i = 0; i < coin; i++) {
                        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                        lottoList.add(new Lotto(numbers));
                        System.out.println(numbers); // 각 로또 번호 출력
                }
                return lottoList;
        }


        public enum LottoResult {
                FIFTH_PRIZE("3개 일치 (5,000원)", 5000),
                FOURTH_PRIZE("4개 일치 (50,000원)", 50000),
                THIRD_PRIZE("5개 일치 (1,500,000원)", 1500000),
                SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
                FIRST_PRIZE("6개 일치 (2,000,000,000원)", 2000000000),
                NO_PRIZE("꽝", 0);
                private final String description;
                private final int prizeAmount;

                LottoResult(String description, int prizeAmount) {
                        this.description = description;
                        this.prizeAmount = prizeAmount;
                }

                public String getDescription() {
                        return description;
                }

                public int getPrizeAmount() {
                        return prizeAmount;
                }
        }
}
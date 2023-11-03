package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Application {
        public static void main(String[] args) {
                // TODO: 프로그램 구현
                // TODO 추후 Coin 클래스 or 메소드로 구현
                // TODO 주요 기능마다 테스트 코드 작성
                inputCoin();
                System.out.println("입력란 종료");

                System.out.println("당첨 번호를 입력해 주세요.");  //TODO 추후 당첨번호 입력 메소드 분리
                String lottoInput = Console.readLine();
                String[] lottoArray = lottoInput.split(",");
                int[] lottoNumbers = new int[lottoArray.length];
                for (int i = 0; i < lottoArray.length; i++) {
                        lottoNumbers[i] = Integer.parseInt(lottoArray[i].trim());
                }
//                System.out.println(lottoStr);

        }

        public static void inputCoin() {
                while (true) {
                        System.out.println("구입금액을 입력해 주세요.");   //구입 금액 입력
                        String coinInput = Console.readLine();
                        try {
                                if (validCoinInput(coinInput)) {
                                        int coin = Integer.parseInt(coinInput) / 1000;
                                        System.out.println(coin+"개를 구매했습니다.");
                                        toChangeLotto(coin);
                                        break;
                                }
                        } catch (IllegalArgumentException e) {
                                System.out.println("[ERROR] 1000원 단위로 입력해 주세요");
                                throw new IllegalArgumentException();
                        }
                }
        }
        public static boolean validCoinInput(String coinInput) {

                        if (Integer.parseInt(coinInput) % 1000 != 0) {
                                System.out.println("[ERROR] 1000원 단위로 입력해 주세요");
                                throw new IllegalArgumentException();
                        }
                        return true;
        }
        public static void toChangeLotto(int coin) {    //받은 로또
                List<Lotto> lottoList = new ArrayList<>();
                for (int i = 0; i < coin; i++) {
                        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                        lottoList.add(new Lotto(numbers));         //TODO 추후수정 임시 변수 저장
                        System.out.println(numbers);              //로또 확인값
                }
                        System.out.println("lottoList = " + lottoList);
        }

}

package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodTest extends NsTest {
        @Test
        public void 입력값이_유효할때() {
                assertTrue(Lotto.validCoinInput("3000"));
                assertTrue(Lotto.validCoinInput("10000"));
        }
        @Test
        public void 입력값이_유효하지_않을때() {
                assertFalse(Lotto.validCoinInput("1001"));
                assertFalse(Lotto.validCoinInput("900"));
                assertFalse(Lotto.validCoinInput("abc")); // 문자열은 유효하지 않음
        }

        @Override
        public void runMain() {
                Application.main(new String[]{});
        }

}

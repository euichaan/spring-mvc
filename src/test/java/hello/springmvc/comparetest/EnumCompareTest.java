package hello.springmvc.comparetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import hello.springmvc.basic.compare.Ranking;

class EnumCompareTest {

	@Test
	void 동등연산자는_NPE를_발생시키지_않는다() {
		Ranking ranking = null;

		assertAll(
			() -> System.out.println(ranking.equals(Ranking.FIRST)), // NPE
			() -> System.out.println(ranking == Ranking.FIRST) // false
		);
	}

	@Disabled
	@Test
	void equals는_타입이_맞지않아도_컴파일된다() {
		Ranking ranking = Ranking.FIRST;

		// assertAll(
		// 	() -> System.out.println(ranking.equals(Rank.FIRST)),
		// 	() -> System.out.println(ranking == Rank.FIRST) // 컴파일 타임 에러
		// );
	}
}

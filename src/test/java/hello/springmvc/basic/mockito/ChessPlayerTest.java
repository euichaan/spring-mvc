package hello.springmvc.basic.mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChessPlayerTest {

	/**
	 * 1.doNothing
	 * 2.doCallRealMethod
	 * 3.doThrow
	 * 4.doAnswer
	 */

	@Test
	void testAssignCategorySpy() throws Exception {
		ChessPlayer chessPlayer = new ChessPlayer("Magnus", 50);
		final ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

		doNothing().when(chessPlayerSpy).assignCategory();
		chessPlayerSpy.assignCategory();
		assertThat("Senior").isEqualTo(chessPlayerSpy.getCategory());
	}

	@Test
	void testAssignCategoryMock() throws Exception {
		final ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

		given(chessPlayerMock.getAge()).willReturn(30);
		doCallRealMethod().when(chessPlayerMock).assignCategory();
		doCallRealMethod().when(chessPlayerMock).getCategory();

		chessPlayerMock.assignCategory();

		assertThat("Senior").isEqualTo(chessPlayerMock.getCategory());
	}

	@Test
	void testAssignCategoryMockException() throws Exception {
		final ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

		doThrow(Exception.class).when(chessPlayerMock)
			.assignCategory();

		assertThatThrownBy(chessPlayerMock::assignCategory)
			.isInstanceOf(Exception.class);
	}

	@Test
	void testAssignScoreStats() {
		ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
		final ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

		doAnswer((chessP) -> {
			final ChessPlayer player = (ChessPlayer)chessP.getMock();
			player.setWins(3);
			player.setPoints(9);
			return null;
		}).when(chessPlayerSpy).assignScoreStats();

		chessPlayerSpy.assignScoreStats();
		assertThat(chessPlayerSpy.getWins()).isEqualTo(3);
		assertThat(chessPlayerSpy.getPoints()).isEqualTo(9);
	}
}
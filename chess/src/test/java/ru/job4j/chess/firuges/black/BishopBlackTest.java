package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BishopBlackTest {

    @Test
    public void whenRightPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C6);
        Assertions.assertEquals(Cell.C6, bishopBlack.position());
    }

    @Test
    public void whenRightCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C6);
        Assertions.assertEquals(bishopBlack.position(), bishopBlack.copy(Cell.C6).position());
    }

    @Test
    public void whenRightWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assertions.assertArrayEquals(steps, bishopBlack.way(Cell.G5));
    }

    @Test
    public void whenNoRightDiagonalInWay() {
        try {
            BishopBlack bishopBlack = new BishopBlack(Cell.C1);
            bishopBlack.way(Cell.D3);
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Could not way by diagonal from C1 to D3"));
        }
    }
}
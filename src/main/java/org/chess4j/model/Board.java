package org.chess4j.model;

import java.util.Map;
import java.util.function.Predicate;

/**
 * A Board maps tile coordinates to pieces. A Board captures a specific position
 * of a chess game in a specific turn. Additionally to the {@link Map} interface
 * the board interface offers a filtered view of the board which contains only
 * mappings which adhere to a given predicate.
 * </p>
 * As all maps a board is generally considered equal to a given map if all
 * mappings are considered equal.
 */
public interface Board extends Map<Tile, Piece> {

    /**
     * Returns view of all pieces that test {@code true} to the given predicate. The
     * view is backed by the given board and modifications are reflected on this
     * board and vice-versa.
     *
     * @param predicate the predicate all mappings of the filtered board must
     *                  fulfill.
     * @return a filtered view of all pieces on the board that test positive to the
     *         given predicate.
     */
    public Board filter(Predicate<Piece> predicate);

    /**
     * Returns a visual string representation based on how a physical board would
     * look like opposed to the normal string representation of typical map
     * implementations.
     *
     * @return a ordered string representation of how this board would look like.
     */
    @Override
    String toString();

    /**
     * Returns an unmodifiable Board that is backed the given board.
     *
     * @param board the given board.
     * @return an unmodifiable board.
     */
    public static Board unmodifiable(Board board) {
        return Utils.unmodifiable(board);
    }

    /**
     * Returns an unmodifiable copy of the given Board. Changes on the returned
     * Board are not reflected on this instance.
     *
     * @param board the given board.
     * @return an unmodifiable board.
     */
    public static Board copy(Board board) {
        return Utils.copy(board);
    }

    /**
     * Returns a fully set up board with pieces in initial starting positions.
     *
     * @return a new fully set up board.
     */
    public static Board newGame() {
        return Utils.newGame();
    }
}

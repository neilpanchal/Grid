public class Grid {

    private int xWidth;
    private int yWidth;

    private int xPadding;
    private int yPadding;

    private int xDensity;
    private int yDensity;

    private int xSpacing;
    private int ySpacing;

    private Cell[][] cells;

    public Grid(int xWidth_, int yWidth_, int xDensity_, int yDensity_, int xPadding_, int yPadding_) {

        this.xWidth = xWidth_;
        this.yWidth = yWidth_;

        this.xDensity = xDensity_;
        this.yDensity = yDensity_;

        this.xPadding = xPadding_;
        this.yPadding = yPadding_;

        this.xSpacing = (xWidth_ - (2 * xPadding_)) / xDensity_;
        this.ySpacing = (yWidth_ - (2 * yPadding_)) / yDensity_;
    }

    public Grid(int xWidth_, int yWidth_, int xDensity_, int yDensity_) {

        this(xWidth_, yWidth_, xDensity_, yDensity_, xWidth_ / xDensity_, yWidth_ / yDensity_);
    }

    public Cell[][] generateGrid(int xDensity_, int yDensity_, int xSpacing_, int ySpacing_) {
        // Implement recursion logic here.
        return new Cell[][]
    }

}

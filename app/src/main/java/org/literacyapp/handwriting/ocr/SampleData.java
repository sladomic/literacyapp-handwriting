package org.literacyapp.handwriting.ocr;

/**
 * SampleData: Holds sampled data that will be used to train the neural network.
 */
public class SampleData implements Comparable<SampleData>, Cloneable {

	/**
	 * The downsampled data as a grid of booleans.
	 */
	protected boolean grid[][];

	/**
	 * The letter.
	 */
	protected String letter;

	/**
	 * The constructor
	 * 
	 * @param letter
	 *            What letter this is
	 * @param width
	 *            The width
	 * @param height
	 *            The height
	 */
	public SampleData(final String letter, final int width, final int height) {
		this.grid = new boolean[width][height];
		this.letter = letter;
	}

	/**
	 * Clear the downsampled image
	 */
	public void clear() {
		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid[0].length; y++) {
				this.grid[x][y] = false;
			}
		}
	}

	/**
	 * Create a copy of this sample
	 * 
	 * @return A copy of this sample
	 */
	@Override
	public Object clone()

	{

		final SampleData obj = new SampleData(this.letter, getWidth(),
				getHeight());
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				obj.setData(x, y, getData(x, y));
			}
		}
		return obj;
	}

	/**
	 * Compare this sample to another, used for sorting.
	 * 
	 * @param o
	 *            The object being compared against.
	 * @return Same as String.compareTo
	 */

	public int compareTo(final SampleData o) {
		final SampleData obj = o;
		return getLetter().compareTo(obj.getLetter());
		/*if (getLetter() > obj.getLetter()) {
			return 1;
		} else {
			return -1;
		}*/
	}

	/**
	 * Get a pixel from the sample.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @return The requested pixel
	 */
	public boolean getData(final int x, final int y) {
		return this.grid[x][y];
	}

	/**
	 * Get the height of the down sampled image.
	 * 
	 * @return The height of the downsampled image.
	 */
	public int getHeight() {
		return this.grid[0].length;
	}

	/**
	 * Get the letter that this sample represents.
	 * 
	 * @return The letter that this sample represents.
	 */
	public String getLetter() {
		return this.letter;
	}

	/**
	 * Get the width of the downsampled image.
	 * 
	 * @return The width of the downsampled image
	 */
	public int getWidth() {
		return this.grid.length;
	}

	/**
	 * Set one pixel of sample data.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @param v
	 *            The value to set
	 */
	public void setData(final int x, final int y, final boolean v) {
		this.grid[x][y] = v;
	}

	/**
	 * Set the letter that this sample represents.
	 * 
	 * @param letter
	 *            The letter that this sample represents.
	 */
	public void setLetter(final String letter) {
		this.letter = letter;
	}

	/**
	 * Convert this sample to a string.
	 * 
	 * @return Just returns the letter that this sample is assigned to.
	 */
	@Override
	public String toString() {
		return "" + this.letter;
	}

}

package battleship.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record Pos(int row, int col) {
	
	public Pos(String pos) {
	    this(parseRowFromPositionString(pos),
	    		parseColFromPositionString(pos));
	}

	
	public Pos next(Orientation orientation) {
		if(orientation == Orientation.VERTICAL)
			return new Pos(row+1,col);
		else
			return new Pos(row,col+1);	
	}
	
	public Pos next(Orientation orientation, int k) {
		if(orientation == Orientation.VERTICAL)
			return new Pos(row+k,col);
		else
			return new Pos(row,col+k);
	}
	
	public boolean isWithin(int size) {
		return row<=size && row > 0 && col<=size && col>=0;
	}
	
	public boolean exceeds(int size, String string) {
		boolean exceeds = row>size || col> size;
		if(exceeds)
			System.out.println(string);
		return exceeds;
	}
	
	public boolean isColumnLessOrEqualTo(Pos other) {
		return this.col<=other.col;
	}

	public boolean isColumnEqualTo(Pos other) {
		
		return this.col == other.col;
	}
	
	public boolean isColumnGreaterOrEqualTo(Pos other) {
		return this.col >= other.col;
	}
	
	public boolean isRowLessOrEqualTo(Pos other) {
		return this.row <= other.row;
	}
	
	
	public boolean isRowEqualTo(Pos other) {
		return this.row == other.row;
	}
	
	public boolean isRowGreaterOrEqualTo(Pos other) {
		return this.row >= other.row;
	} 
	
	public int getOrdinal(int size) {
		return (row-1) * size + (col-1);
	}
	
	public static boolean contains(Pos[] positions, Pos pos) {
        return Arrays.asList(positions).contains(pos);
    }

    public static Pos[] findCommons(Pos[] collection1, Pos[] collection2) {
        Set<Pos> set1 = new HashSet<>(Arrays.asList(collection1));
        Set<Pos> set2 = new HashSet<>(Arrays.asList(collection2));
        set1.retainAll(set2);
        return set1.toArray(new Pos[0]);
    }
	
	private static int parseColFromPositionString(String pos) {
		char colChar = pos.charAt(0);
		return Character.toUpperCase(colChar) - 'A' +1;
	}
	
	private static int parseRowFromPositionString(String pos) {
		String rowStr = pos.substring(1);
		return Integer.parseInt(rowStr);
	}
	
	@Override
	public String toString() {
		char colChar = (char) ('A' + (col - 1));
		return String.format("%c%d", colChar, row);
	}
	
}

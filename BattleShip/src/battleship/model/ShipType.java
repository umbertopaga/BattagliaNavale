package battleship.model;

public enum ShipType {
	SOMMERGIBILE(1),CACCIATORPEDINIERE(2),INCROCIATORE(3),PORTAEREI(4);
	
	private int len;
	
	ShipType(int i) {
		this.len = i;
	}

	public int getLength() {
		return len;
	}
	
	public static ShipType of(int length) {
        for (ShipType type : ShipType.values()) {
            if (type.getLength() == length) {
                return type;
            }
        }
        throw new IllegalArgumentException("No ShipType found for length: " + length);
    }
}

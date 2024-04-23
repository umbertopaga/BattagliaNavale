package battleship.model;

public class Ship {
	private int integrity;
	private String name;
	private Orientation orientation;
	private Pos pos;
	private ShipType type;
	
	public Ship(ShipType type, Pos pos, Orientation orientation, String name) {
		this.name = name;
		this.orientation = orientation;
		this.pos = pos;
		this.type = type;
		this.integrity = type.getLength();
	}
	
	public ShotResult decreaseIntegrity() {
		if(integrity>0)
			integrity--;
		return (integrity>0) ? ShotResult.COLPITO : ShotResult.AFFONDATO;
	}
	
	public int getIntegrity() {
		return integrity;
	}
	
	public Pos getLastPos() {
        // Calcola la posizione finale in base all'orientamento e alla lunghezza
        int row = pos.row();
        int col = pos.col();
        if (orientation == Orientation.VERTICAL) {
            row += type.getLength() - 1;
        } else {
            col += type.getLength() - 1;
        }
        return new Pos(row, col);
    }
	
	public String getName() {
		return name;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	public Pos getPos() {
		return pos;
	}
	
	 public Pos[] getPositions() {
	        // Ottieni tutte le posizioni della nave in base alla sua posizione e lunghezza
	        Pos[] positions = new Pos[type.getLength()];
	        int row = pos.row();
	        int col = pos.col();
	        
	        for (int i = 0; i < type.getLength(); i++) {
	            if (orientation == Orientation.VERTICAL) {
	                positions[i] = new Pos(row + i, col);
	            } else {
	                positions[i] = new Pos(row, col + i);
	            }
	        }
	        
	        return positions;
	    }
	
	public ShipType getType() {
		return type;
	}
	
	public boolean isOrientationEqualTo(Ship other) {
		return this.getOrientation().equals(other.getOrientation());
	}
	
	public boolean overlaps(Pos pos) {
		return Pos.contains(this.getPositions(), pos);
	}
	
	public boolean overlaps(Ship other) {
		return Pos.findCommons(this.getPositions(), other.getPositions()).length>0;
	}
	
	public int getLength() {
		return type.getLength();
	}
	
	public String toString() {
		return "NAVE: " + this.getName() + "\n";
	}
}

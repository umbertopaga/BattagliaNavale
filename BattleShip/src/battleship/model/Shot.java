package battleship.model;

public record Shot(Pos pos, ShotResult result) {

    public Pos pos() {
        return pos;
    }
    
    public ShotResult result() {
        return result;
    }
}

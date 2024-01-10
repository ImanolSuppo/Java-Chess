package ar.edu.utn.frc.tup.lciii.Enums;

public enum TypeParts {

    TOWER,HORSE,BISHOP,QUEEN,KING,PAWN,NULL;


    public static TypeParts parse(String text) {
        if (TOWER.name().equalsIgnoreCase(text)) {
            return TOWER;
        } else if (HORSE.name().equalsIgnoreCase(text)) {
            return HORSE;
        } else if (BISHOP.name().equalsIgnoreCase(text)) {
            return BISHOP;
        } else if (QUEEN.name().equalsIgnoreCase(text)) {
            return QUEEN;
        } else if (KING.name().equalsIgnoreCase(text)) {
            return KING;
        } else if (PAWN.name().equalsIgnoreCase(text)) {
            return PAWN;
        } else {
            return NULL;
        }
    }
}
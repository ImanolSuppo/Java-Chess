package ar.edu.utn.frc.tup.lciii.Enums;

public enum AxisX {


    A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8);

    private final int value;

    AxisX(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AxisX fromLetter(String letter) {
        for (AxisX axisX : AxisX.values()) {
            if (axisX.name().equalsIgnoreCase(letter)) {
                return axisX;
            }
        }
        throw new IllegalArgumentException("Invalid option. Please select a valid option.");
        //TODO ELIMINAR POR MALA PRACTICA.
    }

    public static AxisX fromValue(int value) {
        for (AxisX axisX : AxisX.values()) {
            if (axisX.value == value) {
                return axisX;
            }
        }
        throw new IllegalArgumentException("Invalid option. Please select a valid option.");
        //TODO ELIMINAR POR MALA PRACTICA.
    }
}



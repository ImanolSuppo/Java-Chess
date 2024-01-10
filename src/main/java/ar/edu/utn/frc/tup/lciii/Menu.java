package ar.edu.utn.frc.tup.lciii;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    Scanner scanner = new Scanner(System.in);
    Messages message = new Messages();

    public void start() {
        System.out.println(message.getMensajeInicio());

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número entero.");
            scanner.next();
        }
        int opt = scanner.nextInt();
        while (!(opt == 1 || opt == 2 || opt == 3 || opt == 4)){
            System.out.println("Ese valor no es una opción valida del menu, intente nuevamente!");
            opt = scanner.nextInt();
        }
        optionsMenu(opt);
    }

    public void optionsMenu(int option) {
        if (option == 1) {
            NewGame nuevoJuego = new NewGame();
            nuevoJuego.IniciarJuego();
        } else if (option == 2) {
            NewGame nuevoJuego = new NewGame();
            nuevoJuego.LoadGame();
        } else if (option == 3) {
            message.howToPlayChess();
            start();
        } else if (option == 4) {
            System.exit(0);
        } else {
            message.messageMistake();
            start();
        }
    }

}

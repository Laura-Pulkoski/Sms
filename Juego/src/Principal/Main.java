package Principal;

import Entidades.Jugador;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setNumeroDeJugador(1);
		jugador2.setNumeroDeJugador(2);
		boolean continuarJugando = true;
		int intentos = 6;
		int letrasAcertadas = 0; // contador de letras acertadas
		String letrasErradas = "";

		String opcionesSeguir[] = { "Iniciar partida", "Salir del programa" };

		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido al ahorcado!", null, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcionesSeguir, opcionesSeguir[0]);

		if (opcion == 0) {
			jugador1.setNombre(Jugador.ingresarNombre(jugador1.getNumeroDeJugador()));
			jugador2.setNombre(Jugador.ingresarNombre(jugador2.getNumeroDeJugador()));

			String palabra = JOptionPane.showInputDialog(jugador1.getNombre()+ " ingrese una palabra");
			String palabraEnClave = palabra;

			for (int i = 0; i < palabra.length(); i++) {
				palabraEnClave = palabraEnClave.replace(palabra.charAt(i), '?');
			}

			char[] arrayPalabraEnClave = palabraEnClave.toCharArray(); // nuevo

			while (continuarJugando) {

				String opcionesLetras[] = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G",
						"H", "J", "K", "L", "Ñ", "Z", "X", "C", "V", "B", "N", "M" };

				int letra = JOptionPane.showOptionDialog(null, palabraEnClave + "\n Letras Incorrectas: " + letrasErradas, jugador2.getNombre() + " elegi una letra",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesLetras, opcionesLetras[0]);

				for (int i = 0; i < palabra.length(); i++) { // recorre la palabra letra por letra

					String caracter = String.valueOf(palabra.charAt(i)); // letra que esta en la posicion i
					if (caracter.equals(opcionesLetras[letra].toLowerCase())) { // reemplazo en caso q este la letra que
																				// elegi por esa letra
						arrayPalabraEnClave[i] = palabra.charAt(i); // {'C','?','r','?','a','l'} -> ejemplo adivinando
						letrasAcertadas++;
						JOptionPane.showMessageDialog(null, "Correcto!");
					}
					
				
					palabraEnClave=String.valueOf(arrayPalabraEnClave); // "C???" //se le podria cambiar el nombre a la variable
				}

				if (!(palabra.contains(opcionesLetras[letra].toLowerCase()))) { // nuevo hay un error ahi
					letrasErradas += opcionesLetras[letra].toLowerCase() + "-";
					intentos--;
					JOptionPane.showMessageDialog(null, "Incorrecto!\nTe quedan: " + intentos + " intentos.");
				}


				if (intentos == 0) {
					continuarJugando = false;
					JOptionPane.showMessageDialog(null, "Perdiste! X_X");
					JOptionPane.showMessageDialog(null, "La palabra era: " + palabra); 
				} else if (letrasAcertadas == palabra.length()) {
					continuarJugando = false;
					JOptionPane.showMessageDialog(null, "Ganaste! :D");
				}
			}

		}

		JOptionPane.showMessageDialog(null, "Hasta la próxima!");
		// Agregar las letras que estan mal
		// Mostrar la palbra en codigo en la parte de las letras
	}
}

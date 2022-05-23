package Entidades;

import javax.swing.JOptionPane;

public class Jugador {
//atributos
	private String nombre;
	private int intentos = 6;
	private int numeroDeJugador;

//getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	public int getNumeroDeJugador() {
		return numeroDeJugador;
	}

	public void setNumeroDeJugador(int numeroDeJugador) {
		this.numeroDeJugador = numeroDeJugador;
	}

//constructor vacio


	public Jugador() {

	}

// constructor 

	public Jugador(String nombre, int intentos) {
		this.nombre = nombre;
		this.intentos = intentos;
	}

// to string

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", intentos=" + intentos + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

//metodos

	public static String ingresarNombre(int numeroDeJugador) {
		String nombre = JOptionPane.showInputDialog("Jugador" + numeroDeJugador + " Ingrese su nombre ");
		return nombre;
	}
}

package model.entity;


import java.util.Calendar;
import java.util.List;

import model.entity.enums.Resultado;

public class Partida {

	private int id;
	private Jogador jogador;
	private List<PartidaCarta> cartasJogador;
	private List<PartidaCarta> cartasCpu;
	private int roundsVencidosJogador;
	private int roundsVencidosCpu;
	private int roundsEmpatados;
	private Resultado resultado;
	private Calendar data;
	private boolean jogouForca;
	private boolean jogouInteligencia;
	private boolean jogouVelocidade;
	
	public Partida() {
		super();
	}
	
	public Partida(int id, Jogador jogador, List<PartidaCarta> cartasJogador, List<PartidaCarta> cartasCpu,
			int roundsVencidosJogador, int roundsVencidosCpu, int roundsEmpatados, Resultado resultado, Calendar data,
			boolean jogouForca, boolean jogouInteligencia, boolean jogouVelocidade) {
		super();
		this.id = id;
		this.jogador = jogador;
		this.cartasJogador = cartasJogador;
		this.cartasCpu = cartasCpu;
		this.roundsVencidosJogador = roundsVencidosJogador;
		this.roundsVencidosCpu = roundsVencidosCpu;
		this.roundsEmpatados = roundsEmpatados;
		this.resultado = resultado;
		this.data = data;
		this.jogouForca = jogouForca;
		this.jogouInteligencia = jogouInteligencia;
		this.jogouVelocidade = jogouVelocidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public List<PartidaCarta> getCartasJogador() {
		return cartasJogador;
	}
	public void setCartasJogador(List<PartidaCarta> cartasJogador) {
		this.cartasJogador = cartasJogador;
	}
	public List<PartidaCarta> getCartasCpu() {
		return cartasCpu;
	}
	public void setCartasCpu(List<PartidaCarta> cartasCpu) {
		this.cartasCpu = cartasCpu;
	}
	public int getRoundsVencidosJogador() {
		return roundsVencidosJogador;
	}
	public void setRoundsVencidosJogador(int roundsVencidosJogador) {
		this.roundsVencidosJogador = roundsVencidosJogador;
	}
	public int getRoundsVencidosCpu() {
		return roundsVencidosCpu;
	}
	public void setRoundsVencidosCpu(int roundsVencidosCpu) {
		this.roundsVencidosCpu = roundsVencidosCpu;
	}
	public int getRoundsEmpatados() {
		return roundsEmpatados;
	}
	public void setRoundsEmpatados(int roundsEmpatados) {
		this.roundsEmpatados = roundsEmpatados;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public boolean isJogouForca() {
		return jogouForca;
	}
	public void setJogouForca(boolean jogouForca) {
		this.jogouForca = jogouForca;
	}
	public boolean isJogouInteligencia() {
		return jogouInteligencia;
	}
	public void setJogouInteligencia(boolean jogouInteligencia) {
		this.jogouInteligencia = jogouInteligencia;
	}
	public boolean isJogouVelocidade() {
		return jogouVelocidade;
	}
	public void setJogouVelocidade(boolean jogouVelocidade) {
		this.jogouVelocidade = jogouVelocidade;
	}
}
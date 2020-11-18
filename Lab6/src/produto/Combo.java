package produto;

import java.util.HashMap;
import java.util.HashSet;

public class Combo extends Produto {
	
	private HashMap<String,Produto> produtos;
	private double fator;
	
	public Combo(String nome, String descricao, double preco, double fator, HashMap<String,Produto> produtos) {
		super(nome, descricao, preco);
		this.fator = fator;
		this.produtos = produtos;
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
	public void modificaCombo(double novoFator) {
		this.setFator(novoFator);
	}
	
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getDescricao() + " - R$" + String.format("%.2f", super.getPreco() * (1 - this.fator));
	}
	
}

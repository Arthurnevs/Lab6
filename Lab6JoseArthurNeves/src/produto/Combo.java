package produto;

import java.util.HashMap;
/**
 * Classe que representa um combo, que tem nome, descricao, preco fator e produtos.
 * 
 * @author Jose Arthur Neves
 *
 */
public class Combo extends Produto {
	
	/**
	 * HashMap contendo os produtos do combo.
	 */
	private HashMap<String,Produto> produtos;
	/**
	 * Fator de desconto do combo.
	 */
	private double fator;
	/**
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @param fator
	 * @param produtos
	 */
	public Combo(String nome, String descricao, double preco, double fator, HashMap<String,Produto> produtos) {
		super(nome, descricao, preco);
		this.fator = fator;
		this.produtos = produtos;
	}
	/**
	 * 
	 * @return Referencia do atributo produtos.
	 */
	public HashMap<String,Produto> getProdutos() {
		return produtos;
	}
	/**
	 * Altera o atributo Fator.
	 * @param fator
	 */
	public void setFator(double fator) {
		this.fator = fator;
	}
	/**
	 * Modifica o fator do combo.
	 */
	public void modificaCombo(double novoFator) {
		this.setFator(novoFator);
	}
	/**
	 * Representação textual da classe combo.
	 * @return String contendo informacoes sobre combo.
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getDescricao() + " - R$" + String.format("%.2f", super.getPreco() * (1 - this.fator));
	}

	
}

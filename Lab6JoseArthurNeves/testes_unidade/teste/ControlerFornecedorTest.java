package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fornecedor.ControlerFornecedor;

class ControlerFornecedorTest {

	private ControlerFornecedor c;
	
	@BeforeEach
	public void criaControlerFornecedor() {
		c = new ControlerFornecedor();
	}
	@Test
	public void adicionaCombo() {
		c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
		c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
		c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
		c.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
		assertEquals("X-burguer + suco - X-burguer com suco de maracuja - R$4,50",c.exibeProduto("X-burguer + suco", "X-burguer com suco de maracuja","Seu Olavo"));
	}
	@Test
	public void adicionaComboJaExiste() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			c.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: combo ja existe.");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboFornecedorNaoExiste() {
		try {
			c.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fornecedor nao existe.");
		}catch(IllegalArgumentException npe) {
			
		}
	}
	@Test
	public void adicionaComboFornecedorVazio() {
		try{
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboFornecedorNull() {
		try{
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo(null, "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}catch(NullPointerException npe) {
			
		}
	}
	@Test
	public void adicionaComboNomeVazio() {
		try{
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboNomeNull() {
		try{
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", null, "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}catch(NullPointerException npe) {
			
		}
	}
	@Test
	public void adicionaComboDescricaoVazio() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboDescricaoNull() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco",null, 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}catch(NullPointerException npe) {
			
		}
	}
	@Test
	public void adicionaComboFatorMaior() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", 1.5,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fator invalido.");
		
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboFatorMaiorLimite() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", 1.0,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fator invalido.");
		
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboFatorMenor() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", -0.5,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fator invalido.");
		
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboFatorMenorLimite() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", 0.0,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: fator invalido.");
		
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboSemProdutos() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", 0.25,"");
			fail("Erro no cadastro de combo: combo deve ter produtos.");
		}catch(IllegalArgumentException iae) {
			
		}
	}
	@Test
	public void adicionaComboProdutosNull() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco","X-burguer com suco de maracuja", 0.25,null);
			fail("Erro no cadastro de combo: combo deve ter produtos.");
		}catch(NullPointerException npe) {
			
		}
	}
	@Test
	public void adicionaComboProdutoNaoExiste() {
		try {
			c.adicionaFornecedor("Seu Olavo", "aaa", "333333333");	
			c.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
			c.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
			fail("Erro no cadastro de combo: produto nao existe.");
		}catch(IllegalArgumentException iae) {
			
		}
		
	}
	@Test
	public void adicionaComboCompostoPorCombos() {
		try{
			
		}
	}
	

	

}

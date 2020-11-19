package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.*;

class ComboTest {

	private Combo combo;
	
	@BeforeEach
	public void criaCombo() {
		Produto p1 = new Produto("X-burguer","Hamburguer de carne com queijo e calabresa",5);
		Produto p2 = new Produto("Suco","Suco de maracuja (copo)",5);
		HashMap<String,Produto> p= new HashMap<String,Produto>();
		p.put(p1.getNome()+ p1.getDescricao(), p1);
		p.put(p2.getNome()+ p2.getDescricao(), p2);
		combo = new Combo("X-burguer + suco", "X-burguer com suco de maracuja",10, 0.25,p);
	}
	@Test
	public void TestModificaCombo() {
		combo.modificaCombo(0.5);
		assertEquals("X-burguer + suco - X-burguer com suco de maracuja - R$5,00",combo.toString());
	}
	@Test
	public void TestEquals() {
		HashMap<String,Produto> p = new HashMap<String,Produto>();
		Combo combo2 = new Combo("X-burguer + suco", "X-burguer com suco de maracuja",10, 0.25,p);
		assertTrue(combo.equals(combo2));
	}
	@Test
	public void TestEqualsNull() {
		assertFalse(combo.equals(null));
	}
	@Test
	public void TestEqualDiferente() {
		HashMap<String,Produto> p = new HashMap<String,Produto>();
		Combo combo2 = new Combo("Coxinha de Frango + suco", "Coxinha de frango com suco de maracuja",10, 0.25,p);
		assertFalse(combo.equals(combo2));
	}
	@Test
	public void TestToString() {
		assertEquals("X-burguer + suco - X-burguer com suco de maracuja - R$7,50",combo.toString());
	}
}

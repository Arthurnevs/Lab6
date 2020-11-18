package facade;

public class Main {

	public static void main(String[] args) {
		
		Facade f = new Facade();
		f.adicionaFornecedor("Seu Olavo","aaaa@DDDDD", "4002-8922");
		f.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", 3);
		f.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", 3);
		f.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.25,
				"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
		
		System.out.println(f.exibeProduto("Seu Olavo","X-burguer + suco", "X-burguer com suco de maracuja"));

		f.editaCombo("X-burguer + suco", "X-burguer com suco de maracuja", "Seu Olavo", 0.5);
		
		System.out.println(f.exibeProduto("Seu Olavo","X-burguer + suco", "X-burguer com suco de maracuja"));
		
	}

}

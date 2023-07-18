package tabelaHash;

import java.util.TreeSet;

public class Tabelahash implements THashMiniProjeto{

	private TreeSet<User>[] tabela;
	private int quantidade;

	@SuppressWarnings("unchecked")
	public Tabelahash(int tamanho) {
		this.tabela = new TreeSet[tamanho];
	}

	public int hash(int id) {
		return id % tabela.length;
	}
	public boolean isCheia() {
		return false;
	}
	public void adicionar(User u) throws Exception {
		int indice = hash(u.getId());

		if(indice < 0 )
			throw new Exception("Id invalido");

		else if(tabela[indice] == null)
			tabela[indice] = new TreeSet<User>();
		tabela[indice].add(u);
		quantidade++;
	}


	public User recuperar(int id) throws Exception {
		if(quantidade == 0)
			throw new Exception("Tabela esta vazia!");

		int indice = hash(id);
		if(indice < 0 || indice > tabela.length-1)
			throw new Exception("Id invalido!");

		TreeSet<User> user = tabela[indice];
		if(user != null) {
			for (User user2 : user) {
				if(user2.getId() == id)
					return user2;
			}
		}
		throw new Exception("Elemento nao encontrado!");
	}
	public void print() {
		if(quantidade == 0) {
			System.out.println("Vazio");
			return;
		}
		System.out.print("INICIO -> ");
		for(int i = 0; i<tabela.length;i++) {
			if(tabela[i] != null) {
				TreeSet<User> user = tabela[i];
				for (User u : user) {
					System.out.print(u.getNome()+" (ID "+u.getId()+") -> ");
				}
			}
		}
		System.out.println("FIM");
	}
	
	@SuppressWarnings("unchecked")
	public void crescer() {
		TreeSet<User>[] novaTabela = new TreeSet[tabela.length];
		novaTabela = tabela;
		tabela = new TreeSet[tabela.length*2];
		quantidade = 0;
		for(int i = 0;i<novaTabela.length;i++) {
			if(novaTabela[i] != null) {
				TreeSet<User> user = novaTabela[i];
				for(User u: user) {
					try {
						adicionar(u);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public int qtd() {
		return quantidade;
	}
}

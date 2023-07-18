package tabelaHash;

public class User implements Comparable<User>{
	
	private int id;
	private String nome;
	
	public User(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Nome: "+this.nome+" ID: "+this.getId();
	}

	@Override
	public int compareTo(User u) {		
		return this.getNome().compareTo(u.getNome());
	}
	
}

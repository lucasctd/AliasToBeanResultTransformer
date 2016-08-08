
public class Pessoa {
	
	private String name;
	private Pessoa filho;
	private Carro carro;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pessoa getFilho() {
		return filho;
	}

	public void setFilho(Pessoa filho) {
		this.filho = filho;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}

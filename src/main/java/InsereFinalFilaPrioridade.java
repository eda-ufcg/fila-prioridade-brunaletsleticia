import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair n = new Pair(elemento,prioridade);

		this.fila.add(n);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNextt() {
		Pair n = this.fila.get(0);
		for(int i = 0; i < this.fila.size(); i++) {
			if(n.prioridade < this.fila.get(i).prioridade)
				n = this.fila.get(i); 
		}
		String out = n.elemento;
		this.fila.remove(n);
		return out;
	}
	
	public String removeNext() {
		Pair elem = this.fila.get(0);
		
		for(int j = 0; j < this.fila.size(); j++) {
			if(this.fila.get(j).getPrioridade() > elem.getPrioridade()) {
				elem = this.fila.get(j);
			}
		}
		this.fila.remove(elem);
		return elem.getElemento();
		
		
	}
	
    public String mostra() {
    	String saida = "";
    	for(Pair c : fila) {
    		saida += c.getElemento() + " ";
    		
    	}
    	return saida;
    }
}

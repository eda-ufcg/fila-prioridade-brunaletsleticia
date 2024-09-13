import java.util.ArrayList;

/*
 * adicionando no final (O(1)) e buscando o de maior prioridade O(n)
 */
public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair novo = new Pair(elemento, prioridade);
		fila.add(novo);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		Pair no = fila.get(0);
		for(int j = 0; j <= fila.size(); j++){
			if (fila.get(j).getPrioridade() >= no.getPrioridade()){
				no = fila.get(j);
			}
		}
		return no.getElemento();
	}

}

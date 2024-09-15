public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if(isEmpty()) {
            this.head = 0;
		}
		
        this.last = (this.last + 1) % this.fila.length;
        this.fila[last] = new Pair(elemento, prioridade);
		
		for (int c = last; c != this.head ; c = (c - 1 + this.fila.length) % this.fila.length) {
			if(this.fila[c].getPrioridade() > this.fila[c-1].getPrioridade()) {
				Pair aux = this.fila[c];
				this.fila[c] = this.fila[c-1];
				this.fila[c-1] = aux;
				/*
				 * c não tiver uma prioridade maior que o elemento anterior 
				 * (ou seja, a fila já está em ordem correta até esse ponto), 
				 * o laço é interrompido com o comando break. 
				 * Não há necessidade de continuar movendo o elemento, 
				 * pois já está na posição correta.
				 */
			} else {
				break;
			}
		}
	}
	private boolean isEmpty() {
		return this.last == -1 && this.head == -1;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String saida = this.fila[this.head].getElemento();
		this.head = (this.head + 1) % this.fila.length;
		return saida;
	}

public String mostra() {
    String saida = "";
    for (Pair c : fila) {
        if (c != null) {
            saida += c.getElemento() + " ";
        }
    }
    return saida;
}
}

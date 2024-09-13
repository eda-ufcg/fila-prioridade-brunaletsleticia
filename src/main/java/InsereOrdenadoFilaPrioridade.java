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
		if(prioridade >= fila.length){
			throw new IndexOutOfBoundsException();
		}
		Pair novo = new Pair(elemento, prioridade);
		if(this.last == -1 && this.head == -1){
			this.fila[0] = novo;
		} 
		else{
			for(int j = 1; j <= this.last -1; j++){
				if(novo.getPrioridade() >= fila[j].getPrioridade()){
					this.fila[j-1] = novo;
			}
		}
	}
		this.head +=1;
		this.last +=1;

	}
/*
 * preciso comparar com cada um do array pra ver quem tem a maior prioridade, do comeco ao fim, achar um local em que o proximo dele é menor que ele, 
 * e colocar ele na posicao anterior a esse numero 
 */

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		Pair elem = fila[last];
		this.last -=1;
		return elem.getElemento();

	}

}

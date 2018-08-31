package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoArray implements RepositorioProduto {

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private Produto[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoArray(int size) {
		this.produtos = new Produto[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int result = -1;
		for(int i = 0; i <= index; i++) {
			if(produtos[i].getCodigo() == codigo) {
				result = i;
				break;
			}
		}return result;
	}

	@Override
	public boolean existe(int codigo) {
		boolean result = false;
		if(procurarIndice(codigo) != -1)
			result = true;
		return result;
	}

	@Override
	public void inserir(Produto produto) {
		if(index+1 < produtos.length)
			produtos[++index] = produto;
	}

	@Override
	public void atualizar(Produto produto) {
		int indice = procurarIndice(produto.getCodigo());
		if(indice == -1)
			throw new IllegalArgumentException();
		
		produtos[indice] = produto;
		
	}

	@Override
	public void remover(int codigo) {
		int indice = procurarIndice(codigo);
		if(indice == -1)
			throw new IllegalArgumentException();
		
		for(int i = indice; i < index; i++)
			produtos[i] = produtos[i+1];
		produtos[index] = null;
		index--;
	}

	@Override
	public Produto procurar(int codigo) {
		int indice = procurarIndice(codigo);
		if(indice == -1)
			throw new IllegalArgumentException();
		
		return produtos[indice];
	}
}

package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 *
 * @author Adalberto
 * @param <T>
 */
public class RepositorioProdutoArrayList<T extends Produto> implements RepositorioProduto<T> {

	/**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	private ArrayList<Produto> produtos;

	public RepositorioProdutoArrayList(int size) {
		super();
		this.produtos = new ArrayList<>(size);
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
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCodigo() == codigo) {
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
	public void inserir(T produto) {
		produtos.add(produto);
	}

	@Override
	public void atualizar(T produto) {
		int indice = procurarIndice(produto.getCodigo());
		if(indice == -1)
			throw new IllegalArgumentException();
		
		produtos.set(indice, produto);
	}

	@Override
	public void remover(int codigo) {
		int indice = procurarIndice(codigo);
		if(indice == -1)
			throw new IllegalArgumentException();
		
		produtos.remove(indice);
	}


	@Override
	public Produto procurar(int codigo) {
		int indice = procurarIndice(codigo);
		if(indice == -1) {
			//throw new IllegalArgumentException();
			return null;
			/*
			 * !!!!! LEIA_AQUI !!!!!
			 * Estou ciente de que eh ma pratica dois pontos de retorno, porem encontrei
			 * esta incoerencia dos testes com as especificacoes, que sempre mandam lancar
			 * um erro em caso de item inexistente (meu codigo original atendendo essa
			 * especificacao estando comentado logo acima), porem quando rodei os testes
			 * eles estao utilizando um assertNull para esta situacao especifica, o que
			 * eu acredito que seja um erro dos testes. Nao vou modificar os testes, mas
			 * coloquei este return null como solucao "temporaria".
			 */
		}
		
		return produtos.get(indice);
	}
}

package service.vacinacao;

import java.util.List;

import model.entity.vacinacao.Vacina;
import model.repository.vacinacao.VacinaRepository;
import model.seletor.VacinaSeletor;

public class VacinaService {

	private VacinaRepository repository = new VacinaRepository();
	
	public Vacina salvar(Vacina novaVacina){
		return repository.salvar(novaVacina);
	}

	public boolean atualizar(Vacina vacinaEditada) {
		return repository.alterar(vacinaEditada);
	}

	public boolean excluir(int id) {
		return repository.excluir(id);
	}

	public Vacina consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public List<Vacina> consultarTodas() {
		return repository.consultarTodos();
	}
	
	public List<Vacina> consultarComFiltros(VacinaSeletor seletor) {
		return repository.consultarComFiltros(seletor);
	}
}

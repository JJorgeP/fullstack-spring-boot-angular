package com.jjp.money.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjp.money.api.model.Lancamento;
import com.jjp.money.api.model.Pessoa;
import com.jjp.money.api.repository.LancamentoRepository;
import com.jjp.money.api.repository.PessoaRepository;
import com.jjp.money.api.service.exception.PessoaInexistenteOuInativoException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if(pessoa.isEmpty() || pessoa.get().isInativo() ) {
			throw new PessoaInexistenteOuInativoException();
		}
		return lancamentoRepository.save(lancamento);
	}

}

package cv.pn.processmanagement.business.identificacao.services;


import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRepository;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class IdentificacaoService implements IIdentificacaoService {

    private final IdentificacaoRepository identificacaoRepository;

    public IdentificacaoService(IdentificacaoRepository identificacaoRepository) {
        this.identificacaoRepository = identificacaoRepository;
    }

    @Override
    public List<IdentificacaoRequest> processarIdentificacoes(List<IdentificacaoDto> identificacoesDto, PessoaRequest pessoaRequest) {

        List<IdentificacaoRequest> indentificacoes = identificacoesDto.stream().map(dto -> {

            IdentificacaoRequest identificacao = new IdentificacaoRequest();
            BeanUtils.copyProperties(dto, identificacao);
            identificacao.setTipo(dto.getTipo());
            identificacao.setNumero(dto.getNumero());
            identificacao.setPaisEmissor(dto.getPaisEmissor());
            identificacao.setDataEmissao(dto.getDataEmissao());
            identificacao.setDataValidade(dto.getDataValidade());
            identificacao.setPessoaRequest(pessoaRequest);
            identificacao.setUserCreate("SYSTEM");
            return identificacao;
         //return identificacaoRepository.save(identificacao);

        }).toList();
        //return indentificacoes;
        return identificacaoRepository.saveAll(indentificacoes);
    }

}

/*@Transactional
public Optional<IdentificacaoRequest> atualizarIdentificacaoExistente(IdentificacaoDto dto, PessoaRequest pessoaRequest) {
    try {
        // Buscar identificação existente
        Optional<IdentificacaoRequest> existingOpt = identificacaoRepository.findByTipoAndNumeroAndPessoaRequest(
                dto.getTipo(),
                dto.getNumero(),
                pessoaRequest
        );

        if (existingOpt.isPresent()) {
            IdentificacaoRequest existing = existingOpt.get();
            // Atualizar dados
            existing.setPaisEmissor(dto.getPaisEmissor());
            existing.setEntidadeEmissora(dto.getEntidadeEmissora());
            existing.setDataEmissao(dto.getDataEmissao());
            existing.setDataValidade(dto.getDataValidade());
            existing.setUserUpdate("SYSTEM");

            IdentificacaoRequest updated = identificacaoRepository.save(existing);
            return Optional.of(updated);
        }

    } catch (Exception e) {
        System.err.println(" Erro ao atualizar identificação: " + e.getMessage());
    }

    return Optional.empty();
}


// MÉTuDO PARA LIMPAR DUPLICATAS EXISTENTES

@Transactional
public int limparDuplicatas(PessoaRequest pessoaRequest) {
    List<IdentificacaoRequest> todas = identificacaoRepository.findByPessoaRequest(pessoaRequest);
    List<IdentificacaoRequest> paraManter = new ArrayList<>();
    int duplicadosRemovidos = 0;

    for (IdentificacaoRequest id : todas) {
        boolean jaNaLista = paraManter.stream()
                .anyMatch(existente ->
                        existente.getTipo().equals(id.getTipo()) &&
                                existente.getNumero().equals(id.getNumero())
                );

        if (jaNaLista) {
            identificacaoRepository.delete(id);
            duplicadosRemovidos++;
        } else {
            paraManter.add(id);
        }
    }

    return duplicadosRemovidos;
}

    }*/


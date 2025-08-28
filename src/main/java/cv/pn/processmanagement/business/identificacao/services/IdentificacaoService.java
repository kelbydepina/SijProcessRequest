/*package cv.pn.processmanagement.business.identificacao.services;


import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRepository;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class IdentificacaoService implements IIdentificacaoService{

    private final IdentificacaoRepository identificacaoRepository;

    public IdentificacaoService(IdentificacaoRepository identificacaoRepository) {
        this.identificacaoRepository = identificacaoRepository;
    }


    @Override
    public List<IdentificacaoRequest> processarIdentificacoes(List<IdentificacaoDto> identificacoes, PessoaRequest pessoaRequest) {

        if (pessoaRequest == null || identificacoes == null || identificacoes.isEmpty()) {
            return Collections.emptyList();
        }

        List<IdentificacaoRequest> result = new ArrayList<>();

        for (IdentificacaoDto dto : identificacoes) {
            IdentificacaoRequest ent = new IdentificacaoRequest();
            BeanUtils.copyProperties(dto, ent);
            ent.setPessoaRequest(pessoaRequest);
            ent.setUserCreate("SYSTEM");

            pessoaRequest.getIdentificacoes().add(ent);
            result.add(ent);
        }

        return result;
    }
}*/

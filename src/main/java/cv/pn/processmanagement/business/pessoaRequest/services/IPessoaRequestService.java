package cv.pn.processmanagement.business.pessoaRequest.services;


import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IPessoaRequestService {

     APIResponse createPessoa(PessoaDto pessoaDto);

  //APIResponse createPessoa(PessoaResponseDto dto);


}

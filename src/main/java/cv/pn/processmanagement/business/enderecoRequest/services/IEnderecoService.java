package cv.pn.processmanagement.business.enderecoRequest.services;


import cv.pn.processmanagement.business.enderecoRequest.EnderecoDto;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IEnderecoService {

    APIResponse  processarEndereco(EnderecoDto endereco, String pessoaRequest);
}

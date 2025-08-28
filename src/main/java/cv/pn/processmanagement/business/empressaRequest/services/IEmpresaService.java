package cv.pn.processmanagement.business.empressaRequest.services;

import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IEmpresaService {

    public APIResponse createEmpresa(EmpresaDto empresaDto);
}

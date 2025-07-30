package cv.pn.processmanagement.business.processRequest.services;

//import cv.pn.processmanagement.business.historicoprocess.ProcessHistory;
import cv.pn.processmanagement.business.processRequest.CreateProcessDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IProcessService {


    APIResponse saveProcessStep(CreateProcessDto dto);
    APIResponse getAllProcessIntruction();


}

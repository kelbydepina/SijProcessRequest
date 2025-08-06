package cv.pn.processmanagement.business.atorRequest.services;


import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IAtorRequestService {

    APIResponse saveAtorRequest(CreateAtorRequestDto dto, String processRequest);

    APIResponse getAllAtor();
}

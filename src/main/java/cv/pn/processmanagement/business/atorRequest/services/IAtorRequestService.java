package cv.pn.processmanagement.business.atorRequest.services;


import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IAtorRequestService {

    APIResponse saveAtorRequestStep(CreateAtorRequestDto dto);


    APIResponse getAllAtor();
}

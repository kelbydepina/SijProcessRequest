package cv.pn.processmanagement.business.atorRequest.services;


import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.utilities.APIResponse;

import java.util.List;

public interface IAtorRequestService {

    APIResponse saveAtorRequest(List<CreateAtorRequestDto> atoresDtos, String processRequest);



    //APIResponse getAllAtor();




}

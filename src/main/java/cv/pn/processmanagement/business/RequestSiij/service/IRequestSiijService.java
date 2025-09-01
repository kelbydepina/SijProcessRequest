package cv.pn.processmanagement.business.RequestSiij.service;

import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;
import cv.pn.processmanagement.utilities.APIResponse;

public interface IRequestSiijService {

    APIResponse saveFullProcess(RequestSiijDto dto);

}

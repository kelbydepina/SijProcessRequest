package cv.pn.processmanagement.business.atorRequest;

import cv.pn.processmanagement.commons.CommonsParametrizationAttributesDto;

import java.io.Serializable;

public class AtorDto implements Serializable {

    private String observation;
    private CommonsParametrizationAttributesDto actorsCharacteristics;
    private CommonsParametrizationAttributesDto personType;
    private CommonsParametrizationAttributesDto actorType;
    private CommonsParametrizationAttributesDto dataOrigin;

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public CommonsParametrizationAttributesDto getActorsCharacteristics() {
        return actorsCharacteristics;
    }

    public void setActorsCharacteristics(CommonsParametrizationAttributesDto actorsCharacteristics) {
        this.actorsCharacteristics = actorsCharacteristics;
    }


    public CommonsParametrizationAttributesDto getPersonType() {
        return personType;
    }

    public void setPersonType(CommonsParametrizationAttributesDto personType) {
        this.personType = personType;
    }

    public CommonsParametrizationAttributesDto getActorType() {
        return actorType;
    }

    public void setActorType(CommonsParametrizationAttributesDto actorType) {
        this.actorType = actorType;
    }

    public CommonsParametrizationAttributesDto getDataOrigin() {
        return dataOrigin;
    }

    public void setDataOrigin(CommonsParametrizationAttributesDto dataOrigin) {
        this.dataOrigin = dataOrigin;
    }
}

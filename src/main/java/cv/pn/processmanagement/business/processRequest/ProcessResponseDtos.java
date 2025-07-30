package cv.pn.processmanagement.business.processRequest;

import cv.pn.processmanagement.commons.CommonsParametrizationAttributesDto;

import java.time.LocalDateTime;

public class ProcessResponseDtos extends ProcessDto {

    private String id;
    private String userCreate;
    private Boolean active;
    private LocalDateTime dateCreate;

    private CommonsParametrizationAttributesDto organic;
    private CommonsParametrizationAttributesDto processType;
    private String status;
    private CommonsParametrizationAttributesDto processPhase;
    private String identifierProcess;
    private String referenceProcess;

    private String colorProcess;
    private String remainingProcessDate;
    private String durationProcessDate;

    private CommonsParametrizationAttributesDto processClassification;

    private String changePhaseNote;
    private CommonsParametrizationAttributesDto command;
    private Boolean effectiveOrganic;

    private String subCrimeTypeCode;
    private String subCrimeTypeDescription;
    private String priorityCode;
    private String priorityDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public CommonsParametrizationAttributesDto getOrganic() {
        return organic;
    }

    public void setOrganic(CommonsParametrizationAttributesDto organic) {
        this.organic = organic;
    }

    public CommonsParametrizationAttributesDto getProcessType() {
        return processType;
    }

    public void setProcessType(CommonsParametrizationAttributesDto processType) {
        this.processType = processType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(CommonsParametrizationAttributesDto status) {
        this.status = String.valueOf(status);
    }

    public CommonsParametrizationAttributesDto getProcessPhase() {
        return processPhase;
    }

    public void setProcessPhase(CommonsParametrizationAttributesDto processPhase) {
        this.processPhase = processPhase;
    }

    public String getIdentifierProcess() {
        return identifierProcess;
    }

    public void setIdentifierProcess(String identifierProcess) {
        this.identifierProcess = identifierProcess;
    }

    public String getReferenceProcess() {
        return referenceProcess;
    }

    public void setReferenceProcess(String referenceProcess) {
        this.referenceProcess = referenceProcess;
    }

    public String getColorProcess() {
        return colorProcess;
    }

    public void setColorProcess(String colorProcess) {
        this.colorProcess = colorProcess;
    }

    public String getRemainingProcessDate() {
        return remainingProcessDate;
    }

    public void setRemainingProcessDate(String remainingProcessDate) {
        this.remainingProcessDate = remainingProcessDate;
    }

    public String getDurationProcessDate() {
        return durationProcessDate;
    }

    public void setDurationProcessDate(String durationProcessDate) {
        this.durationProcessDate = durationProcessDate;
    }

    public CommonsParametrizationAttributesDto getProcessClassification() {
        return processClassification;
    }

    public void setProcessClassification(CommonsParametrizationAttributesDto processClassification) {
        this.processClassification = processClassification;
    }

    public String getChangePhaseNote() {
        return changePhaseNote;
    }

    public void setChangePhaseNote(String changePhaseNote) {
        this.changePhaseNote = changePhaseNote;
    }

    public CommonsParametrizationAttributesDto getCommand() {
        return command;
    }

    public void setCommand(CommonsParametrizationAttributesDto command) {
        this.command = command;
    }

    public Boolean getEffectiveOrganic() {
        return effectiveOrganic;
    }

    public void setEffectiveOrganic(Boolean effectiveOrganic) {
        this.effectiveOrganic = effectiveOrganic;
    }

    public String getSubCrimeTypeCode() {
        return subCrimeTypeCode;
    }

    public void setSubCrimeTypeCode(String subCrimeTypeCode) {
        this.subCrimeTypeCode = subCrimeTypeCode;
    }

    public String getSubCrimeTypeDescription() {
        return subCrimeTypeDescription;
    }

    public void setSubCrimeTypeDescription(String subCrimeTypeDescription) {
        this.subCrimeTypeDescription = subCrimeTypeDescription;
    }

    public String getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public String getPriorityDescription() {
        return priorityDescription;
    }

    public void setPriorityDescription(String priorityDescription) {
        this.priorityDescription = priorityDescription;
    }
}

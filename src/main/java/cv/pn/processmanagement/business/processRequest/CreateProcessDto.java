package cv.pn.processmanagement.business.processRequest;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateProcessDto { //é um DTO de entrada, ou seja, ele encapsula todos os dados que o cliente envia para o backend ao criar um novo registro de processo jurídico. Ele permite separar a lógica da entidade ProcessIntruction, protegendo-a contra alterações diretas e mantendo o sistema desacoplado.

    //Indicam o criador e a situação inicial da ocorrência (presença do fato, detectado...).
    private Boolean presenceOfTheFact;
    private Boolean movedAndDetected;
    private LocalDateTime communicationDate;
    //Representam os campos do processo jurídico em si, como tipo de crime, número do processo, observações, etc.
    private String crimeType;
    private String observation;
    private String investigationDaysNumber;
    private String district;
    private String section;
    private String autoNumber;
    private String processNumber;
    private String complaintOrigin;
    private String referenceNumber;
    private String otherNumbers;
    private String attachedProcesses;
    private String mainProcessNumber;
    private LocalDate examinationDeadline;
    private String externalExaminationDeadline;
    private String processTypeDescription;
    private String processTypeCode;
    //Identificadores únicos e referencias internas ou externas para rastreio.
    private String referenceProcess;
    //Permitem categorizar o processo quanto à gravidade, tipo e prioridade de tratamento.
    private String classificationDescription;
    private String classificationCode;
    private String subCrimeTypeDescription;
    private String subCrimeTypeCode;
    private String priorityCode;
    private String priorityDescription;
    //Provavelmente representam o intervalo de tempo em que o processo está vigente ou sob análise.
    private String processDateOf;
    private String processDateUntil;
    //Usado para registrar como, por onde e por quem a comunicação foi feita sobre o processo.
    private String meansOfCommunicationDescription;
    private String meansOfCommunicationCode;
    private String communicationByDescription;
    private String communicationByCode;
    private String communicationAreaDescription;
    private String communicationAreaCode; //Área de comunic
    //Indica a unidade orgânica e o comando responsáveis pelo processo.
    private String commandDescription; //Comando responsável
    private String commandCode; //Comando responsável
    private String organicDescription; //Unidade orgânica
    private String organicCode; //Unidade orgânica



    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getInvestigationDaysNumber() {
        return investigationDaysNumber;
    }

    public void setInvestigationDaysNumber(String investigationDaysNumber) {
        this.investigationDaysNumber = investigationDaysNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getComplaintOrigin() {
        return complaintOrigin;
    }

    public void setComplaintOrigin(String complaintOrigin) {
        this.complaintOrigin = complaintOrigin;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getOtherNumbers() {
        return otherNumbers;
    }

    public void setOtherNumbers(String otherNumbers) {
        this.otherNumbers = otherNumbers;
    }

    public String getAttachedProcesses() {
        return attachedProcesses;
    }

    public void setAttachedProcesses(String attachedProcesses) {
        this.attachedProcesses = attachedProcesses;
    }

    public String getMainProcessNumber() {
        return mainProcessNumber;
    }

    public void setMainProcessNumber(String mainProcessNumber) {
        this.mainProcessNumber = mainProcessNumber;
    }


    public LocalDate getExaminationDeadline() {
        return examinationDeadline;
    }

    public void setExaminationDeadline(LocalDate examinationDeadline) {
        this.examinationDeadline = examinationDeadline;
    }

    public String getExternalExaminationDeadline() {
        return externalExaminationDeadline;
    }

    public void setExternalExaminationDeadline(String externalExaminationDeadline) {
        this.externalExaminationDeadline = externalExaminationDeadline;
    }

    public String getCommunicationAreaDescription() {
        return communicationAreaDescription;
    }

    public void setCommunicationAreaDescription(String communicationAreaDescription) {
        this.communicationAreaDescription = communicationAreaDescription;
    }

    public String getProcessTypeDescription() {
        return processTypeDescription;
    }

    public void setProcessTypeDescription(String processTypeDescription) {
        this.processTypeDescription = processTypeDescription;
    }

    public String getProcessTypeCode() {
        return processTypeCode;
    }

    public void setProcessTypeCode(String processTypeCode) {
        this.processTypeCode = processTypeCode;
    }

    public String getReferenceProcess() {
        return referenceProcess;
    }

    public void setReferenceProcess(String referenceProcess) {
        this.referenceProcess = referenceProcess;
    }

    public String getClassificationDescription() {
        return classificationDescription;
    }

    public void setClassificationDescription(String classificationDescription) {
        this.classificationDescription = classificationDescription;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getProcessDateOf() {
        return processDateOf;
    }

    public void setProcessDateOf(String processDateOf) {
        this.processDateOf = processDateOf;
    }

    public String getProcessDateUntil() {
        return processDateUntil;
    }

    public void setProcessDateUntil(String processDateUntil) {
        this.processDateUntil = processDateUntil;
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

    public Boolean getPresenceOfTheFact() {
        return presenceOfTheFact;
    }

    public void setPresenceOfTheFact(Boolean presenceOfTheFact) {
        this.presenceOfTheFact = presenceOfTheFact;
    }

    public Boolean getMovedAndDetected() {
        return movedAndDetected;
    }

    public void setMovedAndDetected(Boolean movedAndDetected) {
        this.movedAndDetected = movedAndDetected;
    }

    public String getMeansOfCommunicationDescription() {
        return meansOfCommunicationDescription;
    }

    public void setMeansOfCommunicationDescription(String meansOfCommunicationDescription) {
        this.meansOfCommunicationDescription = meansOfCommunicationDescription;
    }

    public String getMeansOfCommunicationCode() {
        return meansOfCommunicationCode;
    }

    public void setMeansOfCommunicationCode(String meansOfCommunicationCode) {
        this.meansOfCommunicationCode = meansOfCommunicationCode;
    }

    public String getCommunicationByDescription() {
        return communicationByDescription;
    }

    public void setCommunicationByDescription(String communicationByDescription) {
        this.communicationByDescription = communicationByDescription;
    }

    public String getCommunicationByCode() {
        return communicationByCode;
    }

    public void setCommunicationByCode(String communicationByCode) {
        this.communicationByCode = communicationByCode;
    }

    public LocalDateTime getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(LocalDateTime communicationDate) {
        this.communicationDate = communicationDate;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }

    public String getOrganicDescription() {
        return organicDescription;
    }

    public void setOrganicDescription(String organicDescription) {
        this.organicDescription = organicDescription;
    }

    public String getOrganicCode() {
        return organicCode;
    }

    public void setOrganicCode(String organicCode) {
        this.organicCode = organicCode;
    }

    public String getCommunicationAreaCode() {
        return communicationAreaCode;
    }

    public void setCommunicationAreaCode(String communicationAreaCode) {
        this.communicationAreaCode = communicationAreaCode;
    }
}

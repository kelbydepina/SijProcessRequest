package cv.pn.processmanagement.business.processRequest;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProcessDto implements Serializable {

    private String id;

    private LocalDateTime processDateOf;
    private LocalDateTime processDateUntil;

    //private CommunicationDto communication;
    private String identifierProcess;
    private String processNumber;
    private String autoNumber;
    private String complaintOrigin;
    private String section;
    private String court;
    private String referenceNumber;
    private Integer numberOfInvestigationDays;
    private Boolean active;
    private String status;
    private LocalDateTime examDeadline;
    private LocalDateTime examinationDeadline;
    private String dmCommandCode;
    private String dmCommandDescription;
    private String organicDescription;
    private String organicCode;
    private String communicationAreaCode;
    private String communicationAreaDescription;
    private String dmCommunicationAreaCode;
    private String dmCommunicationAreaDescription;
    private String dmCommunicationByCode;
    private String dmCommunicationByDescription;
    private LocalDateTime communicationDate;
    private Integer investigationDaysNumber;
    private String district;
    private String otherNumbers;
    private String attachedProcesses;
    private String mainProcessNumber;
    private LocalDate externalExaminationDeadline;
    private String processTypeDescription;
    private String processTypeCode;
    private String referenceProcess;
    private String classificationDescription;
    private String classificationCode;
    private String subCrimeTypeCode;
    private String subCrimeTypeDescription;
    private String priorityCode;
    private String priorityDescription;
    private Boolean presenceOfTheFact;
    private Boolean movedAndDetected;
    private String meansOfCommunicationDescription;
    private String meansOfCommunicationCode;
    private String crimeType;
    private String observation;


    // 👇 Adicionado
    //private String userCreate;

    public LocalDateTime getProcessDateOf() {
        return processDateOf;
    }

    public void setProcessDateOf(LocalDateTime processDateOf) {
        this.processDateOf = processDateOf;
    }

    public LocalDateTime getProcessDateUntil() {
        return processDateUntil;
    }

    public void setProcessDateUntil(LocalDateTime processDateUntil) {
        this.processDateUntil = processDateUntil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifierProcess() {
        return identifierProcess;
    }

    public void setIdentifierProcess(String identifierProcess) {
        this.identifierProcess = identifierProcess;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getComplaintOrigin() {
        return complaintOrigin;
    }

    public void setComplaintOrigin(String complaintOrigin) {
        this.complaintOrigin = complaintOrigin;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Integer getNumberOfInvestigationDays() {
        return numberOfInvestigationDays;
    }

    public void setNumberOfInvestigationDays(Integer numberOfInvestigationDays) {
        this.numberOfInvestigationDays = numberOfInvestigationDays;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExamDeadline() {
        return examDeadline;
    }

    public void setExamDeadline(LocalDateTime examDeadline) {
        this.examDeadline = examDeadline;
    }

    public LocalDateTime getExaminationDeadline() {
        return examinationDeadline;
    }

    public void setExaminationDeadline(LocalDateTime examinationDeadline) {
        this.examinationDeadline = examinationDeadline;
    }


    public String getDmCommandCode() {
        return dmCommandCode;
    }

    public void setDmCommandCode(String dmCommandCode) {
        this.dmCommandCode = dmCommandCode;
    }

    public String getDmCommandDescription() {
        return dmCommandDescription;
    }

    public void setDmCommandDescription(String dmCommandDescription) {
        this.dmCommandDescription = dmCommandDescription;
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

    public String getCommunicationAreaDescription() {
        return communicationAreaDescription;
    }

    public void setCommunicationAreaDescription(String communicationAreaDescription) {
        this.communicationAreaDescription = communicationAreaDescription;
    }

    public String getDmCommunicationAreaCode() {
        return dmCommunicationAreaCode;
    }

    public void setDmCommunicationAreaCode(String dmCommunicationAreaCode) {
        this.dmCommunicationAreaCode = dmCommunicationAreaCode;
    }

    public String getDmCommunicationAreaDescription() {
        return dmCommunicationAreaDescription;
    }

    public void setDmCommunicationAreaDescription(String dmCommunicationAreaDescription) {
        this.dmCommunicationAreaDescription = dmCommunicationAreaDescription;
    }

    public String getDmCommunicationByCode() {
        return dmCommunicationByCode;
    }

    public void setDmCommunicationByCode(String dmCommunicationByCode) {
        this.dmCommunicationByCode = dmCommunicationByCode;
    }

    public String getDmCommunicationByDescription() {
        return dmCommunicationByDescription;
    }

    public void setDmCommunicationByDescription(String dmCommunicationByDescription) {
        this.dmCommunicationByDescription = dmCommunicationByDescription;
    }

    public LocalDateTime getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(LocalDateTime communicationDate) {
        this.communicationDate = communicationDate;
    }

    public Integer getInvestigationDaysNumber() {
        return investigationDaysNumber;
    }

    public void setInvestigationDaysNumber(Integer investigationDaysNumber) {
        this.investigationDaysNumber = investigationDaysNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public LocalDate getExternalExaminationDeadline() {
        return externalExaminationDeadline;
    }

    public void setExternalExaminationDeadline(LocalDate externalExaminationDeadline) {
        this.externalExaminationDeadline = externalExaminationDeadline;
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

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}

package cv.pn.processmanagement.business.processRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.fileRequest.FileRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "SIGO_PROCESS")
public class  ProcessRequest extends CommonsAttributes {


    @Column(name = "crime_type", length = 150, nullable = false)
    @NotBlank(message = "Tipo de crime é obrigatório")
    private String crimeType;  // tipoDeCrime

    @Column(name = "observation", length = 512)
    private String observation;  // observacao

    @Column(name = "investigation_days_number")
    private Integer investigationDaysNumber;  // numeroDeDiasDeInvestigacao

    @Column(name = "district", length = 100)
    private String district;  // comarca

    @Column(name = "section", length = 100)
    private String section;  // secao

    @Column(name = "auto_number", length = 100)
    private String autoNumber;  // numeroDeAuto

    @JsonIgnore
    @Column(name = "process_number", nullable = false)
    @NotBlank(message = "numero de processo obrigatorio ")
    private String processNumber;  // numeroDoProcesso

    @Column(name = "complaint_origin", length = 100)
    private String complaintOrigin;  // origemDaQueixa

    @Column(name = "reference_number", length = 100)
    private String referenceNumber;  // numeroDeReferencia

    @Column(name = "other_numbers", length = 255)
    private String otherNumbers;  // outrosNumeros

    @Column(name = "attached_processes", length = 255)
    private String attachedProcesses;  // processosApensados

    @Column(name = "main_process_number", length = 100)
    private String mainProcessNumber;  // numeroDoProcessoPrincipal

    @Column(name = "status", length = 50)
    private String status;


    // Prazo do exame pericial

    @Column(name = "external_examination_deadline")
    private LocalDate externalExaminationDeadline;  // Prazo do exame externo

    @Column(name = "dm_organic_description", nullable = false)
    @NotBlank(message = "Código da unidade orgânica description  é obrigatório")
    private String organicDescription; //Unidade orgânica

    @Column(name = "dm_organic_code", nullable = false)
    @NotBlank(message = "Código da unidade orgânica é obrigatório")
    private String organicCode; //Unidade orgânica


    @Column(name = "dm_communication_area_description", length = 50, nullable = false)
    @NotBlank(message = "Código da área de description é obrigatório")
    private String communicationAreaDescription; //Área de comunicação

    @Column(name = "dm_communication_area_code", length = 10, nullable = false)
   @NotBlank(message = "Código da área de comunicação é obrigatório")
    private String communicationAreaCode; //Área de comunicação

    @Column(name = "dm_command_code", length = 50, nullable = false)
    @NotBlank(message = "Código da comando é obrigatório")
    private String commandCode;

    @Column(name = "dm_command_description", length = 50, nullable = false)
    @NotBlank(message = "Código de descriçao de comando é obrigatório")
    private String commandDescription;

    @Column(name = "dm_process_type_description", nullable = false)
    @NotBlank(message = "O código de desciçao do tipo de processo é obrigatório")
    private String processTypeDescription; //Tipo do processo

    @Column(name = "dm_process_type_code", nullable = false)
    @NotBlank(message = "O código do tipo de processo é obrigatório")
    private String processTypeCode; //Tipo do processo

    @Column(name = "identifier",length = 50, unique = true, updatable = false) //nullable = false)
    private String identifierProcess; //Identificador técnico do processo

    @Column(name = "reference_process", length = 50)
    private String referenceProcess; //Referência externa

    @Column(name = "dm_classification_description")
    private String classificationDescription;

    @Column(name = "dm_classification_code")
    private String classificationCode;

    @Column(name = "process_date_of")
    private LocalDateTime processDateOf; //Período do processo

    @Column(name = "process_date_until")
    private LocalDateTime processDateUntil; //Período do processo

    @Column(name = "observations", length = 512)
    private String observations;

    @Column(name = "subCrimeType_Code", nullable = false)
    @NotBlank(message = "Código subcrime é obrigatório")
    private String subCrimeTypeCode;

    @Column(name = "subCrimeType_description", nullable = false)
    @NotBlank(message = "Código de discriçao de subcrime é obrigatório")
    private String subCrimeTypeDescription;

    @Column(name = "priority_Code")
    private String priorityCode; //Prioridade do processo

    @Column(name = "priority_Description")
    private String priorityDescription; //Prioridade do processo

    @Column(name = "presence_fact", length = 5, nullable = false)
    @NotNull(message = "Indicação de presença do fato é obrigatória")
    private Boolean presenceOfTheFact;

    @Column(name = "moved_and_detected", length = 5, nullable = false)
    @NotNull(message = "Indicação de movimentação/detecção é obrigatória")
    private Boolean movedAndDetected;

    @Column(name = "dm_means_communication_description", length = 50, nullable = false) //nullable = false)
    @NotBlank(message = "Código do meio de comunicação description é obrigatório")
    private String meansOfCommunicationDescription; //Meio de comunicação

    @Column(name = "dm_means_communication_code", length = 10, nullable = false)
    @NotBlank(message = "Código do meio de comunicação é obrigatório")
    private String meansOfCommunicationCode; //Meio de comunicação

    @Column(name = "dm_communication_by_description", length = 50, nullable = false)
    @NotBlank(message = "Código de discriçao quem comunicou é obrigatório")
    private String communicationByDescription; //Comunicação feita por quem

    @Column(name = "dm_communication_by_code", length = 10, nullable = false)
    @NotBlank(message = "Código de quem comunicou é obrigatório")
    private String communicationByCode; //Comunicação feita por quem

    @Column(name = "communication_date", nullable = false)
    @NotNull(message = "Data da comunicação é obrigatória")
    private LocalDateTime communicationDate; // Data de C omunicaçao

    @Column(name = "court")
    private String court;

    @Column(name = "number_of_investigation_days")
    private Integer numberOfInvestigationDays;

    @Column(name = "exam_deadline")
    private LocalDateTime examDeadline;

    @Column(name = "examination_deadline")
    private LocalDateTime examinationDeadline;

    @JsonIgnore
    @OneToMany(mappedBy = "processRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtorRequest> actors;

    @JsonIgnore
    @OneToMany(mappedBy = "processRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileRequest> files;

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Integer getNumberOfInvestigationDays() {
        return numberOfInvestigationDays;
    }

    public void setNumberOfInvestigationDays(Integer numberOfInvestigationDays) {
        this.numberOfInvestigationDays = numberOfInvestigationDays;
    }

    public LocalDateTime getExamDeadline() {
        return examDeadline;
    }

    public void setExamDeadline(LocalDateTime examDeadline) {
        this.examDeadline = examDeadline;
    }



    public List<FileRequest> getFiles() {
        return files;
    }

    public void setFiles(List<FileRequest> files) {
        this.files = files;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExaminationDeadline() {
        return examinationDeadline;
    }

    public void setExaminationDeadline(LocalDateTime examinationDeadline) {
        this.examinationDeadline = examinationDeadline;
    }

    public LocalDate getExternalExaminationDeadline() {
        return externalExaminationDeadline;
    }

    public void setExternalExaminationDeadline(LocalDate externalExaminationDeadline) {
        this.externalExaminationDeadline = externalExaminationDeadline;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public String getCommunicationAreaDescription() {
        return communicationAreaDescription;
    }

    public void setCommunicationAreaDescription(String communicationAreaDescription) {
        this.communicationAreaDescription = communicationAreaDescription;
    }

    public String getCommunicationAreaCode() {
        return communicationAreaCode;
    }

    public void setCommunicationAreaCode(String communicationAreaCode) {
        this.communicationAreaCode = communicationAreaCode;
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


    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
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

    /*public List<ProcessHistory> getProcessHistories() {
        return processHistories;
    }

    public void setProcessHistories(List<ProcessHistory> processHistories) {
        this.processHistories = processHistories;
    }*/

    public List<AtorRequest> getActors() {
        return actors;
    }

    public void setActors(List<AtorRequest> actors) {
        this.actors = actors;
    }

    /*public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }*/


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
}

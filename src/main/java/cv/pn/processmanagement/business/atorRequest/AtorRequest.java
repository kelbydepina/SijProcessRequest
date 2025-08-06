package cv.pn.processmanagement.business.atorRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "SIGO_ACTOR")
public class AtorRequest extends CommonsAttributes {

    @Column(name = "name", length = 1000)
    @NotBlank(message = "O Autor é obrigatório")
    @Size(max = 1000)
    private String name;

    @Column(name = "nickname", length = 200)
    private String nickname;

    @Column(name = "date_of_birth", length = 10)
    //@Past
    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dateOfBirth;

    @Column(name = "mother_name", length = 100)
    private String motherName;

    @Column(name = "father_name", length = 100)
    private String fatherName;

    @Column(name = "nationality_code", length = 100)
    private String nationalityCode;

    @Column(name = "nationality_description", length = 100)
    private String nationalityDescription;

    @Column(name = "place_of_birth_description", length = 100)
    private String placeOfBirthDescription;

    @Column(name = "place_of_birth_code", length = 100)
    private String placeOfBirthCode;

    @Column(name = "gender_description")
    private String genderDescription;

    @Column(name = "gender_code")
    private String genderCode;

    @Column(name = "marital_status_description")
    private String maritalStatusDescription;

    @Column(name = "marital_Status_code")
    private String maritalStatusCode;

    @Column(name = "citizen_type_description")
    private String citizenTypeDescription;

   @Column(name = "citizen_type_code")
    private String citizenTypeCode;

    @Column(name = "actor_type_code")
    private String actorTypeCode;

    @Column(name = "actor_type_description")
    private String actorTypeDescription;

   @Column(name = "actors_characteristics_description")
    private String actorsCharacteristicsDescription;

    @Column(name = "actors_characteristics_code")
    private String actorsCharacteristicsCode;

    @Column(name = "data_origin_description")
    private String dataOriginDescription;

    @Column(name = "data_origin_code")
    private String dataOriginCode;

    @Column(name = "person_type_description")
    private String personTypeDescription;

    @Column(name = "person_type_code")
    private String personTypeCode;

    private String company;

    private String contact;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_fk", nullable = false)
    private ProcessRequest processRequest;

    public ProcessRequest getProcessRequest() {
        return processRequest;
    }

    public void setProcessRequest(ProcessRequest processRequest) {
        this.processRequest = processRequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNationalityDescription() {
        return nationalityDescription;
    }

    public void setNationalityDescription(String nationalityDescription) {
        this.nationalityDescription = nationalityDescription;
    }

    public String getPlaceOfBirthDescription() {
        return placeOfBirthDescription;
    }

    public void setPlaceOfBirthDescription(String placeOfBirthDescription) {
        this.placeOfBirthDescription = placeOfBirthDescription;
    }

    public String getPlaceOfBirthCode() {
        return placeOfBirthCode;
    }

    public void setPlaceOfBirthCode(String placeOfBirthCode) {
        this.placeOfBirthCode = placeOfBirthCode;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    public void setGenderDescription(String genderDescription) {
        this.genderDescription = genderDescription;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getMaritalStatusDescription() {
        return maritalStatusDescription;
    }

    public void setMaritalStatusDescription(String maritalStatusDescription) {
        this.maritalStatusDescription = maritalStatusDescription;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getCitizenTypeDescription() {
        return citizenTypeDescription;
    }

    public void setCitizenTypeDescription(String citizenTypeDescription) {
        this.citizenTypeDescription = citizenTypeDescription;
    }

    public String getCitizenTypeCode() {
        return citizenTypeCode;
    }

    public void setCitizenTypeCode(String citizenTypeCode) {
        this.citizenTypeCode = citizenTypeCode;
    }

    public String getActorTypeCode() {
        return actorTypeCode;
    }

    public void setActorTypeCode(String actorTypeCode) {
        this.actorTypeCode = actorTypeCode;
    }

    public String getActorTypeDescription() {
        return actorTypeDescription;
    }

    public void setActorTypeDescription(String actorTypeDescription) {
        this.actorTypeDescription = actorTypeDescription;
    }

    public String getActorsCharacteristicsDescription() {
        return actorsCharacteristicsDescription;
    }

    public void setActorsCharacteristicsDescription(String actorsCharacteristicsDescription) {
        this.actorsCharacteristicsDescription = actorsCharacteristicsDescription;
    }

    public String getActorsCharacteristicsCode() {
        return actorsCharacteristicsCode;
    }

    public void setActorsCharacteristicsCode(String actorsCharacteristicsCode) {
        this.actorsCharacteristicsCode = actorsCharacteristicsCode;
    }

    public String getDataOriginDescription() {
        return dataOriginDescription;
    }

    public void setDataOriginDescription(String dataOriginDescription) {
        this.dataOriginDescription = dataOriginDescription;
    }

    public String getDataOriginCode() {
        return dataOriginCode;
    }

    public void setDataOriginCode(String dataOriginCode) {
        this.dataOriginCode = dataOriginCode;
    }

    public String getPersonTypeDescription() {
        return personTypeDescription;
    }

    public void setPersonTypeDescription(String personTypeDescription) {
        this.personTypeDescription = personTypeDescription;
    }

    public String getPersonTypeCode() {
        return personTypeCode;
    }

    public void setPersonTypeCode(String personTypeCode) {
        this.personTypeCode = personTypeCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

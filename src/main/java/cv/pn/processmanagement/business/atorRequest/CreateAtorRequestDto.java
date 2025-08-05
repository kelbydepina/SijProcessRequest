package cv.pn.processmanagement.business.atorRequest;


import java.time.LocalDate;

public class CreateAtorRequestDto {
    //Armazenam as informações básicas da pessoa.
    private String userCreate;
    private String name;
    private String nickname;
    private String motherName;
    private String fatherName;
    private LocalDate dateOfBirth;
    private String processId; // ID do processo ao qual o ator está vinculado
    //Permite vincular o ator ao país e local de nascimento com código e descrição.
    private String nationalityCode;
    private String nationalityDescription;
    private String placeOfBirthDescription;
    private String placeOfBirthCode;
    //Informações demográficas e legais que qualificam a pessoa no contexto jurídico.
    private String genderCode;
    private String genderDescription;
    private String maritalStatusDescription;
    private String maritalStatusCode;
    private String citizenTypeDescription;
    private String citizenTypeCode;
    //Define o papel do ator no processo (ex: vítima, arguido, testemunha, etc.) e suas características.
    private String actorTypeCode;
    private String actorTypeDescription;
    private String actorsCharacteristicsCode;
    private String actorsCharacteristicsDescription;
    //Informa de onde os dados foram extraídos ou inseridos (ex: outro sistema, policial, etc).
    private String dataOriginDescription;
    private String dataOriginCode;
    //Pode diferenciar pessoa física ou jurídica, e se for uma empresa, qual é.
    private String personTypeDescription;
    private String personTypeCode;
    private String company;
    //Provavelmente erro de digitação (deveria ser contact), representa o meio de contato com o ator.
    private String contact;


    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
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

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    public void setGenderDescription(String genderDescription) {
        this.genderDescription = genderDescription;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public String getActorsCharacteristicsCode() {
        return actorsCharacteristicsCode;
    }

    public void setActorsCharacteristicsCode(String actorsCharacteristicsCode) {
        this.actorsCharacteristicsCode = actorsCharacteristicsCode;
    }

    public String getActorsCharacteristicsDescription() {
        return actorsCharacteristicsDescription;
    }

    public void setActorsCharacteristicsDescription(String actorsCharacteristicsDescription) {
        this.actorsCharacteristicsDescription = actorsCharacteristicsDescription;
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

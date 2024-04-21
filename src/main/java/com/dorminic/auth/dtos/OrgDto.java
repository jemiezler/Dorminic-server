package com.dorminic.auth.dtos;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgDto {
    
    
    @NotEmpty
    private String OrgName;

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getOrgkey() {
        return orgkey;
    }

    public void setOrgkey(String orgkey) {
        this.orgkey = orgkey;
    }

    public String getOrgverify() {
        return orgverify;
    }

    public void setOrgverify(String orgverify) {
        this.orgverify = orgverify;
    }

    @NotEmpty
    private String orgkey;

    @NotEmpty
    private String orgverify;
}

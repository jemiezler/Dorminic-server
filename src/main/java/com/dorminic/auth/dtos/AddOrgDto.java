package com.dorminic.auth.dtos;


import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOrgDto {
    private UUID orgID;
    @NotEmpty
    private String OrgName;
    @NotEmpty
    private String orgkey;
    @NotEmpty
    private String orgverify;
}

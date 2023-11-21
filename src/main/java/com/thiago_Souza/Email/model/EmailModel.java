package com.thiago_Souza.Email.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    private String from;
    private String to;
    private String sebject;
    private String text;
}

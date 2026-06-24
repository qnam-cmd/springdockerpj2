package org.spring.springdockerpj2.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String userEmail;
    private String userName;
    private String userPw;
}

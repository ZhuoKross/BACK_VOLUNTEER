package com.projectSenasoft.volunteer.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDTO {

    private String name;
    private String url;
    private byte[] size;

}

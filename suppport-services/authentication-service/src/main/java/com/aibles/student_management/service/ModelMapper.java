package com.aibles.student_management.service;


import com.aibles.student_management.dto.MarkDTO;
import com.aibles.student_management.dto.SubjectDTO;
import com.aibles.student_management.dto.UserDTO;
import com.aibles.student_management.entities.Mark;
import com.aibles.student_management.entities.Subject;
import com.aibles.student_management.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface ModelMapper {
    @Mappings({
            @Mapping(target ="deligence",source = "deligence"),
            @Mapping(target ="midpoint1",source = "midpoint1"),
            @Mapping(target ="midpoint2",source = "midpoint2"),
            @Mapping(target ="status",source = "status"),
            @Mapping(target ="subId",ignore = true),
            @Mapping(target ="userId",source = "user.id"),
            @Mapping(target ="subjectName",source = "subject.subjectname"),
            @Mapping(target="fullName",source="user.fullName")
    })
    MarkDTO convertertoMarkDTO(Mark mark );

    @Mappings({
            @Mapping(target ="subjectname",source = "subjectname"),
            @Mapping(target ="quantity",source = "quantity"),
            @Mapping(target ="semester",source = "semester"),
            @Mapping(target ="id",source = "id")
    })
    SubjectDTO convertertoSubjectDTO(Subject subject);

    @Mappings({
            @Mapping(target ="username",source = "username"),
            @Mapping(target ="password",source = "password"),
            @Mapping(target ="fullName",source = "fullName"),
            @Mapping(target ="address",source = "address"),
            @Mapping(target ="phone",source = "phone"),
            @Mapping(target ="email",source = "email"),
            @Mapping(target ="facebookId",source = "facebookId")
    })
    UserDTO convertertoUserDTO(User user);

}

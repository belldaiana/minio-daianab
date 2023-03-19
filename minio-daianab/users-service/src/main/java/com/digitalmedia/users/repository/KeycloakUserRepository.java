package com.digitalmedia.users.repository;

import com.digitalmedia.users.configuration.KeycloakConfiguration;
import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.*;



@Repository
public class KeycloakUserRepository {

    @Autowired
    private Keycloak keycloackClient;


    public User findByUsername(String username){


        List <UserRepresentation> user;
        user = keycloackClient.realm("digital-media").users()
                .search(username);
        user.forEach(System.out::println);
        return fromRepresentationToEntity(user.get(0));
    }


    public User findById(String id) {
        List<UserRepresentation> usuarios = keycloackClient.realm("digital-media").users().search(id);

        return fromRepresentationToEntity(usuarios.get(0));
    }
    private UserDTO fromRepresentationToDTO(UserRepresentation userRepresentation) {
        return new UserDTO(userRepresentation.getUsername(),userRepresentation.getEmail());
    }

    private User fromRepresentationToEntity(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getUsername(),userRepresentation.getFirstName(),userRepresentation.getLastName(),userRepresentation.getEmail());
    }

}

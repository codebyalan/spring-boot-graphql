package com.ambro.spring.graphql.service;

import com.ambro.spring.graphql.dto.PublicationRec;
import com.ambro.spring.graphql.entity.Publication;
import com.ambro.spring.graphql.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication getPublicationById(Long id){
        return publicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with ID: " + id));
    }

    public Publication addPublication(PublicationRec publicationRec){
        Publication newPublication = new Publication();
        newPublication.setName(publicationRec.name());
        newPublication.setLocation(publicationRec.location());
        return publicationRepository.save(newPublication);
    }

    public List<Publication> getAllPublication(){
        return publicationRepository.findAll();
    }

}

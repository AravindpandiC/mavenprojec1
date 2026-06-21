package com.example.springlearning.service;

import com.example.springlearning.dto.ComponentDto;
import com.example.springlearning.dto.SiteDto;
import com.example.springlearning.entity.Attribute;
import com.example.springlearning.entity.AttributeDto;
import com.example.springlearning.entity.Component;
import com.example.springlearning.entity.Site;
import com.example.springlearning.repository.AttributeRepository;
import com.example.springlearning.repository.ComponentRepository;
import com.example.springlearning.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SiteService {
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    AttributeRepository attributeRepository;


    public List<SiteDto> getSites(Integer orderId) {


        List<Site> sites= siteRepository.findSitesByOrderId(orderId);

        List<SiteDto> siteDtos = new ArrayList<>();
        for(Site site:sites){
            List<Component> components = componentRepository.findComponentsByReferenceIdAndReferenceName(site.getId(),"SITE");

            List<ComponentDto> componentDtos = new ArrayList<>();
            for(Component component:components){
                List<Attribute> attributes = attributeRepository.findAttributesByComponentId(component.getId());
                List<AttributeDto>  attributeDtos = new ArrayList<>();
                for (Attribute attribute:attributes){
                    AttributeDto attributeDto = new AttributeDto(attribute.getComponentId(),attribute.getAttributeName(),attribute.getAttributeValue());
                    attributeDtos.add(attributeDto);
                }
                ComponentDto componentDto = new ComponentDto(component.getId(),component.getReferenceName(),component.getComponentName(),attributeDtos);
                componentDtos.add(componentDto);

            }
            SiteDto siteDto = new SiteDto(site.getSiteName(),site.getLocation(),componentDtos);
            siteDtos.add(siteDto);
        }
        return siteDtos;
    }

    public List<SiteDto> getSites2(Integer orderId) {
        List<Site> sites= siteRepository.findSitesByOrderId(orderId);
        List<Long> siteIds = sites.stream().map(Site::getId).toList();



        List<Component> components = componentRepository.findComponentsByReferenceIdInAndReferenceName(siteIds,"SITE");
        List<Long> componentIds = components.stream().map(Component::getId).toList();


        List<Attribute> attributes = attributeRepository.findAttributesByComponentIdIn(componentIds);


        Map<Long,List<AttributeDto>> attributeDtoMap = attributes.stream()
                .collect(Collectors.groupingBy(Attribute::getComponentId,
                        Collectors.mapping(attribute -> new AttributeDto(attribute.getComponentId(),attribute.getAttributeName(),attribute.getAttributeValue()),
                                Collectors.toList())));

        Map<Long,List<ComponentDto>> componentDtoMap = components.stream()
                .collect(Collectors.groupingBy(Component::getReferenceId,
                        Collectors.mapping(component -> new ComponentDto(component.getId(),component.getReferenceName(),component.getComponentName(),attributeDtoMap.get(component.getId())),
                                Collectors.toList())));

        List<SiteDto> siteDtos = sites.stream()
                .map(site -> new SiteDto(site.getSiteName(), site.getLocation(), componentDtoMap.get(site.getId())))
                .toList();

        return siteDtos;

    }
}

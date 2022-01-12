package com.example.HandsOnProjectOnJan.exception;

public class EmployeeResourceNotFoundException extends RuntimeException{
    private String resourceType;
    private String foundResource;
    private Integer foundValue;

    public EmployeeResourceNotFoundException(String resourceType, String foundResource, int foundValue){
        super(String.format ( "%s resource type value %s :%s" , resourceType, foundResource, foundValue));
        this.foundResource= foundResource;
        this.foundValue = foundValue;
        this.resourceType = resourceType;
    }
}

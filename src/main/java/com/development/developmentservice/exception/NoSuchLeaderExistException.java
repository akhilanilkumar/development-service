package com.development.developmentservice.exception;

public class NoSuchLeaderExistException extends Exception {
    public NoSuchLeaderExistException(Long leaderId) {
        super(String.format("No matching records found for Leader: %d", leaderId));
    }
}

package com.sistemacitasmedicas.sistemacitasmedicas.servicios;

public interface EmailSenderServicio {
    void sendEmail(String toUser, String subject, StringBuffer message);
}
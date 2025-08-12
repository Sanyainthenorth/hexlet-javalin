package org.example.hexlet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BasePage {
    // Флеш теперь — карта с ключами "message" и "type"
    private Map<String, String> flash;
    public Map<String, String> getFlash() {
        return flash;
    }

    public void setFlash(Map<String, String> flash) {
        this.flash = flash;
    }
}
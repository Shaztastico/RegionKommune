package org.example.jpaonetomany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Region {

    @Id
    @Column(length = 4)
    public String kode;
    public String navn;
    public String href;

    @OneToMany(mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();

    public Set<Kommune> getKommuner() {
        return kommuner;
    }

    public void setKommuner(Set<Kommune> kommuner) {
        this.kommuner = kommuner;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}



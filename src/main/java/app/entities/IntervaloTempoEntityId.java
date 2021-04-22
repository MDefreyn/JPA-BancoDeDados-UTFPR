package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IntervaloTempoEntityId implements Serializable {

    @Column(name = "intervalo_tempo_id", length = 4)
    private String intervaloTempo;
    @Column(length = 1)
    private String day;
    @Column(name = "inicio_hr")
    private int horaInicio;
    @Column(name = "inicio_min")
    private int minInicio;

    public IntervaloTempoEntityId() {
    }

    public IntervaloTempoEntityId(String intervaloTempo, String day, int horaInicio, int minInicio) {
        this.intervaloTempo = intervaloTempo;
        this.day = day;
        this.horaInicio = horaInicio;
        this.minInicio = minInicio;
    }

    public String getInterTempo() {
        return intervaloTempo;
    }

    public void setInterTempo(String interTempo) {
        this.intervaloTempo = interTempo;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinInicio() {
        return minInicio;
    }

    public void setMinInicio(int minInicio) {
        this.minInicio = minInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervaloTempoEntityId that = (IntervaloTempoEntityId) o;
        return horaInicio == that.horaInicio && minInicio == that.minInicio && intervaloTempo.equals(that.intervaloTempo) && day.equals(that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intervaloTempo, day, horaInicio, minInicio);
    }

}

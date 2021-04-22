package app.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "intervalo_tempo")
public class IntervaloTempoEntity {
    @EmbeddedId
    private IntervaloTempoEntityId intervaloID;
    @Column(name = "fim_hr")
    private int horaFim;
    @Column(name = "fim_min")
    private int minFim;

    public IntervaloTempoEntity() {
    }

    public IntervaloTempoEntity(IntervaloTempoEntityId intervaloID, int horaFim, int minFim) {
        this.intervaloID = intervaloID;
        this.horaFim = horaFim;
        this.minFim = minFim;
    }

    public IntervaloTempoEntityId getIntervaloID() {
        return intervaloID;
    }

    public void setIntervaloID(IntervaloTempoEntityId intervaloID) {
        this.intervaloID = intervaloID;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public int getMinFim() {
        return minFim;
    }

    public void setMinFim(int minFim) {
        this.minFim = minFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervaloTempoEntity that = (IntervaloTempoEntity) o;
        return intervaloID.equals(that.intervaloID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intervaloID);
    }
}

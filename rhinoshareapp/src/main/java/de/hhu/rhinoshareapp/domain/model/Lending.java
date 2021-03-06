package de.hhu.rhinoshareapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lending {
    @Id
    @GeneratedValue
    long lendingID;

    @OneToOne
    Person lendingPerson;

    @OneToOne
    Article lendedArticle;

    Calendar startDate;

    Calendar endDate;

    String formattedStartDate;

    String formattedEndDate;

    boolean isAccepted;

    boolean isReturn;

    boolean isConflict;

    String conflictmessage;

    boolean isDummy;

    boolean isRequestedForSale;

    String warning;

    @OneToOne
    Reservation proPayReservation;

    public Lending(Calendar startDate, Calendar endDate, Person lendingPerson, Article lendedArticle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lendingPerson = lendingPerson;
        this.lendedArticle = lendedArticle;
    }
    public void fillFormattedDates(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        formattedEndDate = dateFormat.format(endDate.getTime());
        formattedStartDate = dateFormat.format(startDate.getTime());
    }

    public Lending(Person lendingPerson, Calendar endDate) {
        this.lendingPerson = lendingPerson;
        this.endDate = endDate;
    }

    public String getOwnerUsername(){

        return lendedArticle.getOwner().getUsername();
    }

}

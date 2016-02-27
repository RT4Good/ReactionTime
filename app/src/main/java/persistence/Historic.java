package persistence;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.sql.Date;

public class Historic extends SugarRecord {
    @Unique
    String score;
    int age;
    Date date;

    // Default constructor is necessary for SugarRecord
    public Historic() {

    }

    public Historic(String score, int age, Date date) {
        this.score = score;
        this.age = age;
        this.date = date;
    }
}
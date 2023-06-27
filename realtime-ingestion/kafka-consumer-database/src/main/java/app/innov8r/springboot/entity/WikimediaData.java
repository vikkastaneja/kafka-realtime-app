package app.innov8r.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wikimedia_recentchange")
@Getter
@Setter
public class WikimediaData implements Serializable {

    private static final long serialVersionUID = -7899972839016212105L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String wikiEventData;


}

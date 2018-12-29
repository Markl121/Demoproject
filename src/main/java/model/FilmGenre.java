package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "filmgenre")
@PrimaryKeyJoinColumn(name = "filmgenreId", referencedColumnName = "materialId")

public class FilmGenre extends Material {

}

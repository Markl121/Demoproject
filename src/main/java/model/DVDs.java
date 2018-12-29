package model;

//import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "dvds")
@PrimaryKeyJoinColumn(name = "dvdsId", referencedColumnName = "materialId")

public class DVDs extends Material {


}

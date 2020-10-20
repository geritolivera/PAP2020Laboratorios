package clases;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public enum InscripcionEnum {
	EN_ESPERA, ACEPTADO, RECHAZADO
}
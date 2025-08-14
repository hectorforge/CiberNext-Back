package pe.edu.cibernext.util;

import java.time.Year;
import java.util.UUID;

public class CodeGeneratorRandom {
    // Example : A25ABCD0005 : A D S (11 digitos)

    public static String generarCodigoUnico(String prefijo, long totalRegistros) {
        int anio = Year.now().getValue() % 100;
        return String.format(
                "%s%02d%s%04d",
                prefijo,
                anio,
                UUID.randomUUID().toString().substring(0, 4).toUpperCase(),
                totalRegistros + 1
        );
    }

}

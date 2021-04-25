package com.fomularioquejasumg.ReporteFecha;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface RegionRepo extends PagingAndSortingRepository<Region, Integer> {

    @Query(
            value = "SELECT c.id as id,\n" +
                    "       c.complain_text as queja,\n" +
                    "       c.request_text as peticion,\n" +
                    "       c.complain_date as fecha,\n" +
                    "       c.invoice_id as factura,\n" +
                    "       sd.sede as sede,\n" +
                    "       p.name as negocio,\n" +
                    "       r.name as region\n" +
                    "FROM status ST\n" +
                    "         JOIN status_type S ON ST.id_status = S.id\n" +
                    "         JOIN complain c on ST.id_complain = c.id\n" +
                    "         JOIN sede_diaco sd on c.id_sede = sd.id\n" +
                    "         JOIN provider p on c.id_provider = p.id\n" +
                    "         JOIN address a on a.id = p.id_address\n" +
                    "         JOIN municipio m on a.id_municipio = m.id\n" +
                    "         JOIN departamento d on m.id_dep = d.id\n" +
                    "         JOIN region r on d.id_region = r.id\n" +
                    "WHERE c.complain_date BETWEEN :from and :to \n" +
                    "ORDER BY  fecha asc",
            nativeQuery = true
    )
    Iterable<Region> getReportByDates(
            @Param("from") String from,
            @Param("to") String to
    );

}

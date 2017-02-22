package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.Report;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 22.02.2017.
 */
public interface ReportDao extends JpaRepository<Report, Integer> {
}

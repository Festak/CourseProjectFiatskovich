package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.Report;

import java.util.Set;

/**
 * Created by Евгений on 22.02.2017.
 */
public interface ReportService {
    Set<Report> getAllReports();
    void makeReport(Report report);
}
